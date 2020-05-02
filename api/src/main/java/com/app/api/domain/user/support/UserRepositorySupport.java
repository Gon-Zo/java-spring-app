package com.app.api.domain.user.support;

import com.app.api.domain.user.User;
import com.app.api.web.dto.LoginResponseDto;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.UserRespoenseDto;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface UserRepositorySupport {

    Optional<Long> update(long id, UserRespoenseDto dto);

    Optional<User> findByUser(LoginResponseDto dto);

    Page<User> findByUsers(PageableDto dto);

}
