package com.app.api.web.manager;

import com.app.api.domain.review.Review;
import com.app.api.service.reivew.ReviewService;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.ReviewResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/manager/review")
public class ManagerReviewController {

    private final ReviewService service;

    @GetMapping("")
    public Page<Review> showPages(PageableDto dto) {
        return service.getPageReview(dto);
    }

    @PutMapping("")
    public void modifyReview() {

    }

    @PostMapping("")
    public void createReview(ReviewResponseDto dto) {
        service.createReview(dto);
    }

    @DeleteMapping("/{seq}")
    public void removeReview(@PathVariable long seq){
        service.removeReview(seq);
    }

}
