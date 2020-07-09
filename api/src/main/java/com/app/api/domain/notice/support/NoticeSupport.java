package com.app.api.domain.notice.support;

import com.app.api.domain.notice.Notice;
import com.app.api.web.dto.NoticeResponseDto;
import com.app.api.web.dto.PageableDto;
import org.springframework.data.domain.Page;

public interface NoticeSupport {

    void update(NoticeResponseDto dto , long seq);

    Page<Notice> findByAll (PageableDto dto);

}
