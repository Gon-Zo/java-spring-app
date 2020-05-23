package com.app.api.web.dto;

import com.app.api.domain.basket.Basket;
import com.app.api.domain.product.Product;
import com.app.api.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class BasketRespnseDto {

    private long productSeq;

    private long userSeq;

    @Setter
    private Product product;

    @Setter
    private User user;

    public Basket toEntity() {
        return Basket.builder()
                .user(user)
                .product(product)
                .build();
    }

}
