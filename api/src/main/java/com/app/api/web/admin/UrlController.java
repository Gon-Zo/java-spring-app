package com.app.api.web.admin;

import com.app.api.domain.url.Url;
import com.app.api.service.url.UrlService;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.UrlResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/url")
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("")
    public void makeUrl(UrlResponseDto dto) {
        urlService.createUrl(dto);
    }

    @PutMapping("/{seq}")
    public void modifyUrl(@PathVariable long seq, UrlResponseDto dto) {
        urlService.updateUrl(seq, dto);
    }

    @DeleteMapping("/{seq}")
    public void removeUrl(@PathVariable long seq) {
        urlService.remove(seq);
    }

    @GetMapping("")
    public Page<Url> showPages(PageableDto dto) {
        return urlService.getPages(dto);
    }

}
