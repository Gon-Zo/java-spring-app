package com.app.api.domain.order;

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
@Table(name = "ORDERS")
public class Order extends BaseEntity {


    @ManyToOne
    @JoinColumn(name = "product_seq")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_seq")
    private User user;

    @Column(name = "cnt")
    private Integer cnt;

    @Builder
    public Order(Product product  , User user  , Integer cnt) {
        this.product = product;
        this.user  = user;
        this.cnt = cnt;
    }

}
