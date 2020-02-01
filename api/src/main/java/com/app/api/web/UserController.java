package com.app.api.web;


import com.app.api.service.user.UserService;
import com.app.api.web.dto.UserRespoenseDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/user")
@RestController
@AllArgsConstructor
public class UserController {

    private final UserService  userService;

    @PostMapping("")
    public void signUpTo(@RequestBody UserRespoenseDto dto){
        userService.saveBy(dto);
    }


}
