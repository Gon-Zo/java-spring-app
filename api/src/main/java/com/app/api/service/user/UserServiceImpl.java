package com.app.api.service.user;

import com.app.api.domain.user.User;
import com.app.api.domain.user.UserRepository;
import com.app.api.domain.user.support.UserRepositorySupport;
import com.app.api.core.error.exception.BusinessException;
import com.app.api.core.error.exception.ErrorCode;
import com.app.api.web.dto.PageableDto;
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

        if(checkByEmail(dto.getEmail())){
            throw new BusinessException(ErrorCode.SAME_USER);
        }

        dto.setPassword(encodingByPwd(dto.getPassword()));

        User user = dto.toEntity();

        userRepository.save(user);
    }

    @Override
    public Long updateFrom(long seq, UserRespoenseDto dto) {
        return userRepositorySupport
                .update(seq, dto)
                .orElseThrow(() ->
                        new BusinessException(ErrorCode.USER_UPDATE_FAIL));
    }

    @Override
    public Page<User> getPageList(Pageable pageable) {
        return userRepository.findAll(pageable);
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
    public Page<User> getUsers(PageableDto dto) {
        return userRepositorySupport.findByUsers(dto);
    }

    // checking to email
    private boolean checkByEmail(String email){
        return ObjectUtils.isNotEmpty(userRepositorySupport.findByEmail(email));
    }

    // encoding passworad
    private String encodingByPwd(String pwd){
        String rawPassword = pwd;
        String encodedPassword = new BCryptPasswordEncoder().encode(rawPassword);
        return  encodedPassword;
    }

}
