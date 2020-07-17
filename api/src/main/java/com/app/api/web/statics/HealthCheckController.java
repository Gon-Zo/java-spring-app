package com.app.api.web.statics;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthCheckController {

    @GetMapping("/check-up")
    public String checkUp(){
        return "SUCCESS";
    }

}
