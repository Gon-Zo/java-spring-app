package com.app.api.web.client;

import com.app.api.domain.review.Review;
import com.app.api.service.reivew.ReviewService;
import com.app.api.web.dto.ReviewResponseDto;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{seq}")
    public void reviseReview(@PathVariable long seq , ReviewResponseDto dto){
       service.modifyReview(seq , dto);
    }

    @DeleteMapping("/{seq}")
    public void removeReview(@PathVariable long seq){
       service.deleteBy(seq);
    }

    @GetMapping("/{seq}")
    public Review showReview(@PathVariable long seq){
        return service.getReview(seq);
    }

}
