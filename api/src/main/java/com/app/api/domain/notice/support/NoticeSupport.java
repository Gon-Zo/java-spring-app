package com.app.api.domain.notice.support;

import com.app.api.web.dto.NoticeResponseDto;

public interface NoticeSupport {

    void update(NoticeResponseDto dto , long seq);
}
