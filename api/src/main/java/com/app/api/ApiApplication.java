package com.app.api;

import com.app.api.core.init.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableJpaRepositories

public class ApiApplication {

    @Autowired
    private InitService initService;

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    // todo : Service opne checking

    @PostConstruct
    public void prevStart(){
//        initService.init();
    }

}
