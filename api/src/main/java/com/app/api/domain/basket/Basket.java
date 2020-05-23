package com.app.api.domain.basket;

import com.app.api.domain.product.Product;
import com.app.api.domain.user.User;
import com.app.api.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "BASEKETS")
public class Basket extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "product_seq")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_seq")
    private User user;

    @Builder
    public Basket(Product product, User user) {
        this.product = product;
        this.user = user;
    }

}
