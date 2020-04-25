package com.app.api.service.user;

import com.app.api.domain.user.User;
import com.app.api.domain.user.UserRepository;
import com.app.api.domain.user.support.UserRepositorySupport;
import com.app.api.global.error.exception.BusinessException;
import com.app.api.global.error.exception.ErrorCode;
import com.app.api.web.dto.LoginViewModel;
import com.app.api.web.dto.UserRespoenseDto;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserRepositorySupport userRepositorySupport;

    @Override
    public void saveBy(UserRespoenseDto dto) {
        String rawPassword = dto.getPassword();
        String encodedPassword = new BCryptPasswordEncoder().encode(rawPassword);
        dto.setPassword(encodedPassword);
        User user = dto.toEntity();
        userRepository.save(user);
    }

    @Override
    public Long updateFrom(long seq, UserRespoenseDto dto) {
        return userRepositorySupport.update(seq, dto)
                        .orElseThrow(()->new BusinessException(ErrorCode.USER_UPDATE_FAIL));
    }

    @Override
    public Page<User> getPageList(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User searchUser(LoginViewModel dto) {

        if (ObjectUtils.isEmpty(dto.getEmail())) {
            throw new BusinessException(ErrorCode.USER_EMAIL_FAIL);
        }

        if (ObjectUtils.isEmpty(dto.getPassword())) {
            throw new BusinessException(ErrorCode.USER_PASSWORD_FAIL);
        }

        return userRepositorySupport
                .findByUser(dto)
                .orElseThrow(() ->
                        new BusinessException(ErrorCode.LOGIN_USER_NOT_FOUND));
    }

    /**
     * delete User
     *
     * @param seq
     */
    @Override
    public void deleteByUser(long seq) {
        userRepository.deleteById(seq);
    }


}
