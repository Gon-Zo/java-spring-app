package com.app.api.web.admin;

import com.app.api.domain.url.Url;
import com.app.api.service.url.UrlService;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.UrlDto;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/url")
public class AdminUrlController {

    private final UrlService urlService;

    public AdminUrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping("")
    public void makeUrl(UrlDto dto) {
        urlService.createUrl(dto);
    }

    @PutMapping("/{seq}")
    public void modifyUrl(@PathVariable long seq, UrlDto dto) {
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
