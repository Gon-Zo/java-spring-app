package com.app.api.service.notice;

import com.app.api.core.error.exception.BusinessException;
import com.app.api.core.error.exception.ErrorCode;
import com.app.api.domain.notice.Notice;
import com.app.api.domain.notice.NoticeRepository;
import com.app.api.domain.notice.support.NoticeSupport;
import com.app.api.domain.user.UserRepository;
import com.app.api.web.dto.NoticeResponseDto;
import com.app.api.web.dto.PageableDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;

@Service
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
    public void updateNotice(NoticeResponseDto dto , @NotNull long seq) {
        noticeSupport.update(dto , seq);
    }

    @Override
    public Notice getNotice(@NotNull long seq) {
        return noticeRepository.findById(seq)
                .orElse(Notice.builder().build());
    }

    @Override
    public Page<Notice> getNoticeList(PageableDto dto) {
        return noticeSupport.findByAll(dto);
    }

    @Override
    @Transactional
    public void removeNotice(@NotNull long seq) {
        noticeRepository.deleteById(seq);
    }

}
