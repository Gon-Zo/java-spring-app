package com.app.api.service.user;

import com.app.api.domain.user.UserRepository;
import com.app.api.domain.user.support.UserRepositorySupport;
import com.app.api.web.dto.UserRespoenseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserRepositorySupport userRepositorySupport;

    @Override
    public void saveBy(UserRespoenseDto dto) {
        userRepository.save(dto.toEntity());
    }

}
