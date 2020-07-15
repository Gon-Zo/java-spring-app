package com.app.api.web.manager;

import com.app.api.domain.notice.Notice;
import com.app.api.service.notice.NoticeService;
import com.app.api.web.dto.NoticeResponseDto;
import com.app.api.web.dto.PageableDto;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/manager/notice")
public class ManagerNoticeController {

    private final NoticeService noticeService;

    public ManagerNoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @PostMapping("")
    public void makeNotice(NoticeResponseDto dto) {
       noticeService.createNotice(dto);
    }

    @PutMapping("/{seq}")
    public void modifyNotice(@PathVariable @NotNull long seq , NoticeResponseDto dto){
        noticeService.updateNotice(dto, seq);
    }

    @DeleteMapping("/{seq}")
    public void removeNotice(@PathVariable @NotNull long seq){
       noticeService.removeNotice(seq);
    }

    @GetMapping("")
    public Page<Notice> showNoticeListData(PageableDto dto){
        return noticeService.getNoticeList(dto);
    }

    @GetMapping("/{seq}")
    public Notice showNotice(@NotNull long seq) {
        return noticeService.getNotice(seq);
    }

}
