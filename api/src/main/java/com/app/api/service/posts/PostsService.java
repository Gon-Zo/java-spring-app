package com.app.api.service.posts;

import com.app.api.domain.posts.Posts;
import com.app.api.web.dto.PostsResponseDto;

import java.util.Optional;

public interface PostsService {
    Optional<Posts> findBy(long id);

    Long save(PostsResponseDto dto);

    Long update(Long id, PostsResponseDto dto);

    Long deleteBy(Long id);
}
