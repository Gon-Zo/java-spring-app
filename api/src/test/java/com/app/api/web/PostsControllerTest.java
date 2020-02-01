package com.app.api.web;


import com.app.api.domain.posts.Posts;
import com.app.api.domain.posts.PostsRepository;
import com.app.api.web.dto.PostsResponseDto;
import org.assertj.core.api.AssertionsForClassTypes;
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
    public void 포스트_저장() throws Exception {
        String title = "title test1";
        String content = "content test ";
        String author = "test-success";

        PostsResponseDto dto = PostsResponseDto.builder().title(title).content(content).author(author).build();


        String url = "http://localhost:" + port + "/posts";

        ResponseEntity<Long> responseEntity = testRestTemplate.postForEntity(url, dto, Long.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        AssertionsForClassTypes.assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Posts> all = postsRepository.findAll();

        AssertionsForClassTypes.assertThat(all.get(0).getTitle()).isEqualTo(title);
    }

    @Test
    public void 포스트_삭제() throws Exception {
        long id = 1;

        포스트_저장();

        String url = "http://localhost:" + port + "/posts/" + id;


        testRestTemplate.delete(url);
    }

    @Test
    public void 포스트_디테일() throws Exception {

        long id = 1;

        포스트_저장();

        String url = "http://localhost:" + port + "/posts/" + id;

        ResponseEntity<Optional> result = testRestTemplate.getForEntity(url, Optional.class);

        assertThat(result.getStatusCode());

        AssertionsForClassTypes.assertThat(result.getBody());

    }

}
