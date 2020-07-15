package com.app.api.web.manager;


import com.app.api.domain.user.User;
import com.app.api.enums.Roles;
import com.app.api.service.user.UserService;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.UserRespoenseDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@AllArgsConstructor
@RequestMapping("/manager/user")
public class ManagerUserController {

    private final UserService userService;

    @PutMapping("/{seq}")
    public Long modifyInfo(@PathVariable long seq, @RequestBody UserRespoenseDto dto) {
        return userService.updateFrom(seq, dto);
    }

    @DeleteMapping("/{seq}")
    public void removeUser(@PathVariable long seq) {
        userService.deleteByUser(seq);
    }

    @GetMapping("/{seq}")
    public User showUser(@PathVariable long seq) {
        return userService.getUser(seq);
    }

    @GetMapping("")
    public Page<User> showPageUsers(PageableDto dto){
        return userService.getUsers(Arrays.asList(Roles.U.getValue()), dto);
    }

}
