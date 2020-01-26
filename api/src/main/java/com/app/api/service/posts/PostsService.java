package com.app.api.service.posts;

import com.app.api.domain.posts.PostsRepository;
import com.app.api.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsResponseDto postsResponseDto) {
        return postsRepository.save(postsResponseDto.toEntity()).getId();
    }

}
