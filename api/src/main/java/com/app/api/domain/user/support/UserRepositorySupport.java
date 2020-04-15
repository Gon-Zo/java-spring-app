package com.app.api.domain.user.support;

import com.app.api.domain.user.User;
import com.app.api.web.dto.UserRespoenseDto;

import java.util.Optional;

public interface UserRepositorySupport {
    Optional<Long> update(long id, UserRespoenseDto dto);
    Optional<User> findByUser(UserRespoenseDto dto);
}
