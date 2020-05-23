package com.app.api.web.client;

import com.app.api.service.like.LikeService;
import com.app.api.web.dto.LikeResponseDto;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/client/like")
@RestController
public class ClientLikeController {

    private final LikeService service;

    public ClientLikeController(LikeService service) {
        this.service = service;
    }

    @GetMapping("")
    public void clickLike(LikeResponseDto dto){
       service.saveBy(dto);
    }

    @DeleteMapping("/{seq}")
    public void notClickLike(@PathVariable long seq){
       service.deleteBy(seq);
    }

}
