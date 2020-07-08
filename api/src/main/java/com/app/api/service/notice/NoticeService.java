package com.app.api.service.notice;

import com.app.api.web.dto.NoticeResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface NoticeService {

    void createNotice(NoticeResponseDto dto);

    void updateNotice(NoticeResponseDto dto , long seq);

}
