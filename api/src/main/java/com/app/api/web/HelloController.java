package com.app.api.web;

import com.app.api.web.dto.HelloResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {


    @GetMapping("/hello")
    public String getHello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(String name, int amount) {
        return new HelloResponseDto(name, amount);
    }

}
