package com.app.api.domain.order;

import com.app.api.domain.product.Product;
import com.app.api.domain.user.User;
import com.app.api.util.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "app_order")
public class Order extends BaseEntity {


    @ManyToOne
    @JoinColumn(name = "product_seq")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_seq")
    private User user;

    @Column(name = "cnt")
    private Integer cnt;

}
