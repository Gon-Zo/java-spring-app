package com.app.api.web.dto;

import com.app.api.domain.posts.Posts;
import lombok.*;

@Getter
//@Setter
@ToString
@NoArgsConstructor
public class PostsResponseDto {

    private String title;
    private String content;
    private String author;


    @Builder
    private PostsResponseDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(this.title)
                .content(this.author)
                .author(this.content).build();
    }


}
