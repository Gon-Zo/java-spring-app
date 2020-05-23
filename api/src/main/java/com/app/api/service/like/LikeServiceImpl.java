package com.app.api.service.like;

import com.app.api.core.error.exception.BusinessException;
import com.app.api.core.error.exception.ErrorCode;
import com.app.api.domain.like.LikeRepository;
import com.app.api.domain.like.support.LikeSupport;
import com.app.api.domain.user.UserRepository;
import com.app.api.web.dto.LikeResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LikeServiceImpl implements LikeService {

    private final LikeSupport support;

    private final LikeRepository repository;

    private final UserRepository userRepository;

    @Override
    public void saveBy(LikeResponseDto dto) {
        dto.setUser(userRepository.findById(dto.getUserSeq())
                .orElseThrow(()-> new BusinessException(ErrorCode.USER_NOT_FOUND)));
        repository.save(dto.toEntity());
    }

    @Override
    public void deleteBy(long seq) {
        repository.deleteById(seq);
    }

}
