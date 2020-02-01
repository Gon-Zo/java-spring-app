package com.app.api.web;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void Hello_출력() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                // 위의 결과 검증
                .andExpect(status().isOk())
                //결과 검증
                .andExpect(content().string(hello));
    }

    @Test
    public void Hello_DTO_출력() throws Exception {
        String name = "test";
        String amount = "10000";

        mvc.perform(get("/hello/dto").param("name", name).param("amount", amount))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount" , is(Integer.valueOf(amount))));
    }

}
