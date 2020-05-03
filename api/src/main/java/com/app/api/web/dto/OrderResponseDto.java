package com.app.api.web.dto;

import com.app.api.domain.product.Product;
import com.app.api.domain.user.User;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
public class OrderResponseDto {

    private long userSeq;

    private long productSeq;

    @Setter
    private User user;

    @Setter
    private Product product;

    @Builder
    public OrderResponseDto(long userSeq, long productSeq) {
        this.userSeq = userSeq;
        this.productSeq = productSeq;
    }
    
}
