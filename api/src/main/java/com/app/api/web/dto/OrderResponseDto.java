package com.app.api.web.dto;

import com.app.api.domain.order.Order;
import com.app.api.domain.product.Product;
import com.app.api.domain.user.User;
import com.app.api.enums.States;
import lombok.*;

@Getter
@ToString
@NoArgsConstructor
public class OrderResponseDto {

    private long userSeq;

    private long productSeq;

    private int cnt;

    private String state;

    @Setter
    private User user;

    @Setter
    private Product product;

    public Order toEntity() {
        return Order.builder()
                .product(this.product)
                .user(this.user)
                .cnt(this.cnt)
                .state(this.state)
                .build();
    }

}
