package com.app.api.web.dto;

import com.app.api.domain.product.Product;
import com.app.api.domain.review.Review;
import com.app.api.domain.user.User;
import lombok.*;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class ReviewResponseDto {

    private String title;

    private String content;

    private Long productSeq;

    private Long userSeq;

    @Setter
    private Product product;

    @Setter
    private User user;

    private List<String> imageVals;

    @Builder
    public ReviewResponseDto(String title, String content, Long productSeq, Long userSeq) {
        this.title = title;
        this.content = content;
        this.productSeq = productSeq;
        this.userSeq = userSeq;
    }

    public Review toEntity()    {
        return Review.builder()
                .title(this.title)
                .content(this.content)
                .user(this.user)
                .product(this.product)
                .build();

    }

}
