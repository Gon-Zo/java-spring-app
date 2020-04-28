package com.app.api.web.manager;


import com.app.api.domain.user.User;
import com.app.api.service.user.UserService;
import com.app.api.web.dto.UserRespoenseDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/manager/user")
public class UserController {

    private final UserService userService;

    // ===== User Info
    @PutMapping("/{seq}")
    public Long modifyInfo(@PathVariable long seq, @RequestBody UserRespoenseDto dto) {
        return userService.updateFrom(seq, dto);
    }

    // ===== Page Users
    @GetMapping("")
    public Page<User> showUserList(
            @PageableDefault(size = 10,
                    page = 0,
                    sort = "seq",
                    direction = Sort.Direction.ASC) Pageable pageable) {
        return userService.getPageList(pageable);
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

}
