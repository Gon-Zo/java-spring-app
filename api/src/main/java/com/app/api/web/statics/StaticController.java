package com.app.api.web.statics;

import com.app.api.core.auth.JwtResponse;
import com.app.api.core.auth.JwtTokenUtil;
import com.app.api.core.auth.JwtUserDetailsService;
import com.app.api.domain.menu.Menu;
import com.app.api.domain.user.User;
import com.app.api.core.error.exception.BusinessException;
import com.app.api.core.error.exception.ErrorCode;
import com.app.api.enums.Roles;
import com.app.api.service.menu.MenuService;
import com.app.api.service.user.UserService;
import com.app.api.web.dto.LoginResponseDto;
import com.app.api.web.dto.UserRespoenseDto;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin
public class StaticController {

    private final UserService userService;
private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;

    private final JwtUserDetailsService userDetailsService;

    private final MenuService menuService;

    public StaticController(UserService userService,
                            AuthenticationManager authenticationManager,
                            JwtTokenUtil jwtTokenUtil,
                            JwtUserDetailsService userDetailsService, MenuService menuService) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
        this.menuService = menuService;
    }

    /**
     * Login User
     *
     * @param dto
     * @return
     * @throws Exception
     */
    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody LoginResponseDto dto) throws Exception{

        checkParam(dto);

        authenticate(dto.getEmail(), dto.getPassword());

        final User userDetails = (User) userDetailsService.loadUserByUsername(dto.getEmail());

        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));

    }

    /**
     * Sign Up to User
     *
     * @param dto
     */
    @PostMapping("sign")
    public void signUpTo(@RequestBody UserRespoenseDto dto , Roles roles) {
        userService.saveBy(dto , roles);
    }

    /**
     * Auth Function
     *
     * @param username
     * @param password
     * @throws Exception
     */
    private void authenticate(String username, String password) throws Exception {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (InternalAuthenticationServiceException e) {
            throw new BusinessException(ErrorCode.LOGIN_USER_NOT_FOUND);
        }catch (DisabledException e) {
            throw new BusinessException(ErrorCode.USER_DISABLED);
        } catch (BadCredentialsException e) {
            throw new BusinessException(ErrorCode.INVALID_CREDENTIALS);
        }

    }

    /**
     * Check To Login User Info
     *
     * @param dto
     */
    private void checkParam(LoginResponseDto dto){

        if (ObjectUtils.isEmpty(dto.getEmail())) {
            throw new BusinessException(ErrorCode.USER_EMAIL_FAIL);
        }

        if (ObjectUtils.isEmpty(dto.getPassword())) {
            throw new BusinessException(ErrorCode.USER_PASSWORD_FAIL);
        }

    }

    /**
     * User's Menu Custom
     *
     * @param authentication
     * @return
     */
    @GetMapping("/menu")
    public List<Menu> showAuthMenus(Authentication authentication) {

        Collection<? extends GrantedAuthority> collect = authentication.getAuthorities();

        Iterator<? extends GrantedAuthority> iterator = collect.iterator();

        List<String> roles = new ArrayList<>();

        while (iterator.hasNext()){
            roles.add(iterator.next().getAuthority());
        }

        return menuService.getAuthMenu(roles);
    }

}
