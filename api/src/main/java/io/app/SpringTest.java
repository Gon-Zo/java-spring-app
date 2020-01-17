package io.app;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

// @SpringBootApplication
// 하위에 있으면 빈객체를 감지
@Component
public class SpringTest {

    // 의존성 주입 및 실행
    @PostConstruct
    public void saySpring() {
        System.out.println("Hello Spring boot 22");
    }

}
