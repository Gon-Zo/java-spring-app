package com.app.api.web;


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

@Slf4j
@RequestMapping("/user")
@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public void signUpTo(@RequestBody UserRespoenseDto dto) {
        userService.saveBy(dto);
    }

    @PutMapping("/{seq}")
    public Long modifyInfo(@PathVariable long seq, @RequestBody UserRespoenseDto dto) {
        return userService.updateFrom(seq, dto);
    }

    /**
     * PageObject uset
     * page >> 페이지 번호
     * size >> num page
     * sort >> order
     *
     * @param pageable
     * @return
     */
    @GetMapping("")
    public Page<User> showUserList(@PageableDefault(size = 10, page = 0, sort = "seq", direction = Sort.Direction.ASC) Pageable pageable) {
        return userService.getPageList(pageable);
    }


    @PostMapping("/login")
    public User userLogin(UserRespoenseDto dto){
        return userService.searchUser(dto);
    }

}
