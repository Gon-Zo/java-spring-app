package com.app.api.web;

import com.app.api.demo.auth.JwtResponse;
import com.app.api.demo.auth.JwtTokenUtil;
import com.app.api.demo.auth.JwtUserDetailsService;
import com.app.api.domain.user.User;
import com.app.api.service.user.UserService;
import com.app.api.web.dto.LoginResponseDto;
import com.app.api.web.dto.UserRespoenseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class LoginController {

    private final UserService userService;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenUtil jwtTokenUtil;

    private final JwtUserDetailsService userDetailsService;

    public LoginController(UserService userService,
                           AuthenticationManager authenticationManager,
                           JwtTokenUtil jwtTokenUtil,
                           JwtUserDetailsService userDetailsService) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    /**
     * ======== All Users Login Controller
     *
     * @param dto
     * @return
     * @throws Exception
     */
    @PostMapping("/login")
    public ResponseEntity<?> userLogin(@RequestBody LoginResponseDto dto) throws Exception{

        authenticate(dto.getEmail(), dto.getPassword());

        final User userDetails = (User) userDetailsService.loadUserByUsername(dto.getEmail());

        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));

    }

    @PostMapping("sign")
    public void signUpTo(@RequestBody UserRespoenseDto dto) {
        userService.saveBy(dto);
    }

    private void authenticate(String username, String password) throws Exception {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            e.printStackTrace();
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            e.printStackTrace();
            throw new Exception("INVALID_CREDENTIALS", e);
        }

    }

}
