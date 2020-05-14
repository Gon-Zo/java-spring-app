package com.app.api.service.user;

import com.app.api.domain.role.Role;
import com.app.api.domain.role.RoleRepository;
import com.app.api.domain.role.UserRole;
import com.app.api.domain.role.support.UserRoleRepository;
import com.app.api.domain.user.User;
import com.app.api.domain.user.UserRepository;
import com.app.api.domain.user.support.UserSupport;
import com.app.api.core.error.exception.BusinessException;
import com.app.api.core.error.exception.ErrorCode;
import com.app.api.enums.Roles;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.UserRespoenseDto;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserSupport userSupport;

    private final RoleRepository roleRepository;

    private final UserRoleRepository userRoleRepository;

    @Override
    public void saveBy(UserRespoenseDto dto , Roles roleType) {

        if(checkByEmail(dto.getEmail())){
            throw new BusinessException(ErrorCode.SAME_USER);
        }

        dto.setPassword(encodingByPwd(dto.getPassword()));

        User user = dto.toEntity();

        user = userRepository.saveAndFlush(user);

        Role role = roleRepository.findByTitle(roleType.getValue());

        userRoleRepository.save(UserRole.builder()
                .user(user)
                .role(role)
                .build());

    }

    @Override
    public Long updateFrom(long seq, UserRespoenseDto dto) {
        return userSupport
                .update(seq, dto)
                .orElseThrow(() ->
                        new BusinessException(ErrorCode.USER_UPDATE_FAIL));
    }

    @Override
    public void deleteByUser(long seq) {
        userRepository.deleteById(seq);
    }

    @Override
    public User getUser(long seq) {
        return userRepository
                .findById(seq)
                .orElseThrow(()-> new BusinessException(ErrorCode.USER_NOT_FOUND));
    }

    @Override
    public Page<User> getUsers(List<String> roleTitles , PageableDto dto) {
        return userSupport.findByUsers( roleTitles , dto);
    }

    private boolean checkByEmail(String email){
        return ObjectUtils.isNotEmpty(userSupport.findByEmail(email));
    }

    private String encodingByPwd(String pwd){
        String rawPassword = pwd;
        String encodedPassword = new BCryptPasswordEncoder().encode(rawPassword);
        return  encodedPassword;
    }

}
