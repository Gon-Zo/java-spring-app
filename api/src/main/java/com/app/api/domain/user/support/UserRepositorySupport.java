package com.app.api.domain.user.support;

import com.app.api.web.dto.UserRespoenseDto;

public interface UserRepositorySupport {
    Long update(long id, UserRespoenseDto dto);
}
