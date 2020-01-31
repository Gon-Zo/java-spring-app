package com.app.api.service.posts;

import com.app.api.web.dto.PostsResponseDto;

public interface PostsService {
    Long save(PostsResponseDto dto);
    Long update(Long id , PostsResponseDto dto);
    Long deleteBy(Long id);
}
