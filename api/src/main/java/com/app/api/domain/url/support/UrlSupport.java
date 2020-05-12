package com.app.api.domain.url.support;

import com.app.api.domain.url.Url;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.UrlResponseDto;
import org.springframework.data.domain.Page;

public interface UrlSupport {

    void update(long seq , UrlResponseDto dto);

    Page<Url> findByPage(PageableDto dto);

}
