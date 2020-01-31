package com.app.api.web;


import com.app.api.domain.posts.Posts;
import com.app.api.domain.posts.PostsRepository;
import com.app.api.web.dto.PostsResponseDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class PostsControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private PostsRepository postsRepository;

    @AfterEach
    public void clear() throws Exception {
        postsRepository.deleteAll();
    }

    @Test
    public void 포스트_저장_테스트() throws Exception {
        // test value
        String title = "title test1";
        String content = "content test ";
        String author = "test-success";

        PostsResponseDto dto = PostsResponseDto.builder().title(title).content(content).author(author).build();


        String url = "http://localhost:" + port + "/posts";

        ResponseEntity<Long> responseEntity = testRestTemplate.postForEntity(url, dto, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRepository.findAll();

        assertThat(all.get(0).getTitle()).isEqualTo(title);

    }


    @Test
    public void 포스트_업데이트_테스트() throws Exception {
        String title = "업데이트";
        String content = "업데이트";
        String author = "업데이트";

        포스트_저장_테스트();

        PostsResponseDto dto = PostsResponseDto.builder().title(title).content(content).author(author).build();

        String url = "http://localhost:" + port + "/posts/1";
        testRestTemplate.put(url, dto, Long.class);
    }


    @Test
    public void 포스트_삭제() throws Exception {
        long id = 1;

        String url = "http://localhost:" + port + "/posts/" + id;

        포스트_저장_테스트();

        testRestTemplate.delete(url);
    }


    @Test
    public void 포스트_디테일_테스트() throws Exception {

        long id = 1;

        String url = "http://localhost:" + port + "/posts/" + id;

        포스트_저장_테스트();

        ResponseEntity<Optional> result = testRestTemplate.getForEntity(url, Optional.class);

        assertThat(result.getStatusCode());

        assertThat(result.getBody());

    }






}
