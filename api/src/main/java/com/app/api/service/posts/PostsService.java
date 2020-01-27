package com.app.api.domain.posts.support.service.posts;

import com.app.api.web.dto.PostsResponseDto;

public interface PostsService {
    Long save(PostsResponseDto dto);
    Long update(Long id , PostsResponseDto dto);
}
