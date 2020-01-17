package io.app.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @GetMapping("/")
    public void getStart() {
        System.out.println("Server Start to 'url' GET / ");
    }

    @GetMapping("/test")
    public void test1() {
        System.out.println("Test 1 success");
    }


}
