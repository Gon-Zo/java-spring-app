package com.app.api.web.dto;

import com.app.api.domain.posts.Posts;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PostsResponseDto {
    private final long id;
    private final String title;
    private final String content;
    private final String author;


    public Posts toEntity() {
        return Posts.builder()
                .title(this.title)
                .content(this.author)
                .author(this.content).build();
    }
}
