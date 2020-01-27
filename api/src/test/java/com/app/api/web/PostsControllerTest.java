package com.app.api.web;


import com.app.api.web.dto.PostsResponseDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class PostsControllerTest {

    @Autowired
    private MockMvc mvc;


    @Test
    public void 포스트_저장_테스트() throws Exception {
        PostsResponseDto dto = new PostsResponseDto("test1", "test2", "test3");

        mvc.perform(post("/posts")
                .param("name", dto.getTitle())
                .param("content", dto.getContent())
                .param("author", dto.getAuthor()))
                .andExpect(status().isOk());

//                .andExpect(jsonPath("${}"))
//                .andExpect()

    }

//    @Test
//    public long 포스트_업데이트(){
//        long id =
//    }
}
