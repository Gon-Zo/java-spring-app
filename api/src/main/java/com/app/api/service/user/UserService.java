package com.app.api.service.user;

import com.app.api.domain.user.User;
import com.app.api.web.dto.LoginResponseDto;
import com.app.api.web.dto.UserRespoenseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    /**
     * Sign up to user
     *
     * @param dto - User save info
     */
    void saveBy(UserRespoenseDto dto);

    /**
     * User info update
     *
     * @param seq
     * @param dto
     * @return
     */
    Long updateFrom(long seq, UserRespoenseDto dto);

    /**
     * Show User List
     * @param pageable
     * @return
     */
    Page<User> getPageList(Pageable pageable);

    /**
     * Login User
     *
     * @param dto
     * @return
     */
    User searchUser(LoginResponseDto dto);


    void deleteByUser(long seq);

}
