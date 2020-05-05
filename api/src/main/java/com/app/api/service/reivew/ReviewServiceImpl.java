package com.app.api.service.reivew;

import com.app.api.domain.review.Review;
import com.app.api.domain.review.ReviewRepository;
import com.app.api.domain.review.Support.ReviewSupport;
import com.app.api.web.dto.PageableDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service @AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {


    private final ReviewSupport support;

    private final ReviewRepository repository;


    @Override
    public Page<Review> getPageReview(PageableDto dto) {

        return null;
    }
}
