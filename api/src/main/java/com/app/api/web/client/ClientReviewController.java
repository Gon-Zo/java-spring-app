package com.app.api.web.client;

import com.app.api.service.reivew.ReviewService;
import com.app.api.web.dto.ReviewResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client/review")
public class ClientReviewController {

    private final ReviewService service;

    public ClientReviewController(ReviewService service) {
        this.service = service;
    }

    @PostMapping("")
    public void writeReview(ReviewResponseDto dto){
        service.createReview(dto);
    }

    @PutMapping()
    public void reviseReview(){

    }

}
