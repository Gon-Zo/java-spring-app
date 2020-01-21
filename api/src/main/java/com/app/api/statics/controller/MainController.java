package com.app.api.statics.controller;

import com.app.api.statics.group.Group;
import com.app.api.statics.group.GroupService;
import com.app.api.statics.user.User;
import com.app.api.statics.user.UserService;
import com.app.api.statics.user.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class MainController {

    private final UserService userService;

    private final GroupService groupService;

    public MainController(UserServiceImpl userService, GroupService groupService) {
        this.userService = userService;
        this.groupService = groupService;
    }

    @GetMapping("/")
    public List<User> test() {
        return userService.allUser();
    }


    @GetMapping("/{title}")
    public User getTest(@PathVariable String title){
        return userService.getUser(title);
    }

    @PostMapping("/group")
    public void createGroup(Group group){
        groupService.saveOf(group);
    }


}
