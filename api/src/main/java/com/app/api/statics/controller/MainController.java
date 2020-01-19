package com.app.api.statics.controller;

import com.app.api.statics.user.User;
import com.app.api.statics.user.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    private final UserServiceImpl userService;

    public MainController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public List<User> test() {
        return userService.allUser();
    }


    @GetMapping("/{title}")
    public User getTest(@PathVariable String title){
        return userService.getUser(title);
    }

}
