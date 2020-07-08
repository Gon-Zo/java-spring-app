package com.app.api.service.notice;

import com.app.api.core.error.exception.BusinessException;
import com.app.api.core.error.exception.ErrorCode;
import com.app.api.domain.notice.NoticeRepository;
import com.app.api.domain.notice.support.NoticeSupport;
import com.app.api.domain.user.UserRepository;
import com.app.api.web.dto.NoticeResponseDto;

public class NoticeServiceImpl implements NoticeService {

    private final NoticeRepository noticeRepository;

    private final NoticeSupport noticeSupport;

    private final UserRepository userRepository;

    public NoticeServiceImpl(NoticeRepository noticeRepository, NoticeSupport noticeSupport, UserRepository userRepository) {
        this.noticeRepository = noticeRepository;
        this.noticeSupport = noticeSupport;
        this.userRepository = userRepository;
    }

    @Override
    public void createNotice(NoticeResponseDto dto) {
        dto.setUser(userRepository.findById(dto.getUserSeq()).orElseThrow(()->new BusinessException(ErrorCode.USER_NOT_FOUND)));
        noticeRepository.save(dto.toEntity());
    }

    @Override
    public void updateNotice(NoticeResponseDto dto , long seq) {
        noticeSupport.update(dto , seq);

    }

}
