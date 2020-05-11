package com.app.api.domain.url.support;

import com.app.api.web.dto.UrlResponseDto;

public interface UrlSupport {

    void update(long seq , UrlResponseDto dto);
}
