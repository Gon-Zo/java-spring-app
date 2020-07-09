package com.app.api.service.notice;

import com.app.api.domain.notice.Notice;
import com.app.api.web.dto.NoticeResponseDto;
import com.app.api.web.dto.PageableDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

public interface NoticeService {

    void createNotice(NoticeResponseDto dto);

    void updateNotice(NoticeResponseDto dto , long seq);

    Notice getNotice (long seq);

    Page<Notice> getNoticeList (PageableDto dto);

    void removeNotice(long seq);

}
