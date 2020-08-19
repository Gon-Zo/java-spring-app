package com.app.api.service.user;

import com.app.api.domain.user.User;
import com.app.api.enums.Roles;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.UserDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    void saveBy(UserDto dto , Roles roleType);

    Long updateFrom(long seq, UserDto dto);

    void deleteByUser(long seq);

    User getUser (long seq);

    Page<User> getUsers(List<String> roleTitles, PageableDto dto);

}
