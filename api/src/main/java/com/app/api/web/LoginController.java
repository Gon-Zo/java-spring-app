package com.app.api.web;

import com.app.api.domain.user.User;
import com.app.api.service.user.UserService;
import com.app.api.web.dto.LoginViewModel;
import com.app.api.web.dto.UserRespoenseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public User userLogin(@RequestBody LoginViewModel dto) {
        return userService.searchUser(dto);
    }

    @PostMapping("sign")
    public void signUpTo(@RequestBody UserRespoenseDto dto) {
        userService.saveBy(dto);
    }

}
