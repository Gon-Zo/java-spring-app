package com.app.api.web.client;

import com.app.api.service.like.LikeService;
import com.app.api.web.dto.LikeResponseDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RequestMapping("/client/like")
@RestController
public class ClientLikeController {

    private final LikeService service;

    public ClientLikeController(LikeService service) {
        this.service = service;
    }

    /**
     * 좋아요 정보 저장
     *
     * @param dto
     */
    @GetMapping("")
    public void clickLike(LikeResponseDto dto){
       service.saveBy(dto);
    }

    /**
     * 좋아요 취소
     *
     * @param seq
     */
    @DeleteMapping("/{seq}")
    public void notClickLike(@PathVariable @NotNull long seq){
       service.deleteBy(seq);
    }

}
