package com.app.api.service.user;

import com.app.api.web.dto.UserRespoenseDto;

public interface UserService {

    /**
     * Sign up to user
     *
     * @param dto - User save info
     */
    void saveBy(UserRespoenseDto dto);
}
