package com.app.api.service.url;

import com.app.api.web.dto.UrlResponseDto;

public interface UrlService {

    void createUrl(UrlResponseDto dto);

    void updateUrl(long seq , UrlResponseDto dto);

    void remove(long seq);

}
