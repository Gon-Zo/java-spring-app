package com.app.api.web.admin;

import com.app.api.domain.user.User;
import com.app.api.service.user.UserService;
import com.app.api.web.dto.PageableDto;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/user")
public class AdminUserController {

    private final UserService userService;

    public AdminUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public Page<User> showPages(PageableDto dto) {
        return userService.getUsers( null , dto);
    }

}
