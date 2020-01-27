package com.app.api.domain.posts.support;

import com.app.api.web.dto.PostsResponseDto;

public interface PostsRepositorySupport {
    long update(Long id, PostsResponseDto dto);
}
