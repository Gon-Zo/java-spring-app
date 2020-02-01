package com.app.api.web;


import com.app.api.domain.user.UserRepository;
import com.app.api.web.dto.UserRespoenseDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private UserRepository userRepository;

    @AfterEach
    public void cleanUser() throws Exception {
        userRepository.deleteAll();
    }

    @Test
    public void 유저_커넥트_테스트() throws Exception {
        System.out.println("Test success");
    }

    @Test
    public void 유저_저장() {
        String email = "tester 1";
        String pwd = "test ininin";

         UserRespoenseDto dto = UserRespoenseDto.builder()
                .email(email)
                .password(pwd)
                .build();

        String url = "http://localhost:" + port + "/user";

        ResponseEntity<Void> voidResponseEntity = testRestTemplate.postForEntity(url, dto, void.class);

        assertThat(voidResponseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat(voidResponseEntity.getBody())s;
    }

}
