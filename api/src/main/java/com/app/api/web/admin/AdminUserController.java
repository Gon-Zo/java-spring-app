package com.app.api.web.admin;

import com.app.api.domain.user.User;
import com.app.api.service.user.UserService;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{seq}")
    public void updateUser(@PathVariable long seq, UserDto dto) {
        userService.updateFrom(seq, dto);
    }

    @DeleteMapping("/{seq}")
    public void removeUser(@PathVariable long seq){
        userService.deleteByUser(seq);
    }

}
