package com.app.api.service.url;

import com.app.api.domain.url.Url;
import com.app.api.domain.url.UrlRepository;
import com.app.api.domain.url.support.UrlSupport;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.UrlDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UrlServiceImpl implements UrlService {

    private final UrlRepository urlRepository;

    private final UrlSupport urlSupport;

    public UrlServiceImpl(UrlRepository urlRepository, UrlSupport urlSupport) {
        this.urlRepository = urlRepository;
        this.urlSupport = urlSupport;
    }

    @Override
    public void createUrl(UrlDto dto) {
        urlRepository.save(dto.toEntity());
    }

    @Override
    public void updateUrl(long seq, UrlDto dto) {
        urlSupport.update(seq, dto);
    }

    @Override
    @Transactional
    public void remove(long seq) {
        urlRepository.deleteById(seq);
    }

    @Override
    public Page<Url> getPages(PageableDto dto) {
        return urlSupport.findByPage(dto);
    }

}
