package com.app.api.service.url;

import com.app.api.domain.url.Url;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.UrlDto;
import org.springframework.data.domain.Page;

public interface UrlService {

    void createUrl(UrlDto dto);

    void updateUrl(long seq , UrlDto dto);

    void remove(long seq);

    Page<Url> getPages (PageableDto dto);

}
