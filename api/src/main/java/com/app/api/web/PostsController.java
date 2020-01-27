package com.app.api.web;

import com.app.api.service.posts.PostsService;
import com.app.api.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostsController {

    private final PostsService postsService;

    @PostMapping("")
    public Long save(PostsResponseDto dto) {
        return postsService.save(dto);
    }

    @PutMapping("/{id}")
    public Long updatePosts(@PathVariable long id, PostsResponseDto dto) {
        return postsService.update(id, dto);
    }

}
