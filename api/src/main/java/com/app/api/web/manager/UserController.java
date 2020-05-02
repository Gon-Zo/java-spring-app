package com.app.api.web.manager;


import com.app.api.domain.user.User;
import com.app.api.service.user.UserService;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.UserRespoenseDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/manager/user")
public class UserController {

    private final UserService userService;

    // ===== Update User Info
    @PutMapping("/{seq}")
    public Long modifyInfo(@PathVariable long seq, @RequestBody UserRespoenseDto dto) {
        return userService.updateFrom(seq, dto);
    }

    // ===== Delete User
    @DeleteMapping("/{seq}")
    public void removeUser(@PathVariable long seq) {
        userService.deleteByUser(seq);
    }

    // ==== Users Info
    @GetMapping("/{seq}")
    public User showUser(@PathVariable long seq) {
        return userService.getUser(seq);
    }

    //=== find By Page Users
    @GetMapping("")
    public Page<User> showPageUsers(PageableDto dto){
       return userService.getUsers(dto);
    }

}
