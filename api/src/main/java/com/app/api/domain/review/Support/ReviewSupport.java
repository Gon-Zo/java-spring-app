package com.app.api.domain.review.Support;

import com.app.api.domain.review.Review;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.ReviewResponseDto;
import org.springframework.data.domain.Page;

public interface ReviewSupport {
    Page<Review> findByReview(PageableDto dto);

    void update( long seq , ReviewResponseDto dto);
}
