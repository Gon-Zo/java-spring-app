package com.app.api.service.reivew;

import com.app.api.domain.review.Review;
import com.app.api.web.dto.PageableDto;
import org.springframework.data.domain.Page;

public interface ReviewService {

    Page<Review> getPageReview (PageableDto dto);
}
