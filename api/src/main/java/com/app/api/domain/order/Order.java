package com.app.api.domain.order;

import com.app.api.domain.product.Product;
import com.app.api.domain.user.User;
import com.app.api.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * Create by park031517@gmail.com on 2020-08-13, 목
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Getter
@Entity
@NoArgsConstructor
@DynamicUpdate
@Table(name = "ORDER")
public class Order extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "product_seq" , nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_seq" , nullable = false)
    private User user;

    @Column(name = "cnt" , nullable = false)
    private Integer cnt;

    @Setter
    @Column(name = "state" , nullable = false)
    private String state;

    @Setter
    @Column(name = "is_cancel")
    private Boolean isCancel;

    @Builder
    public Order(Product product  , User user  , Integer cnt , String state  , Boolean isCancel) {
        this.product = product;
        this.user  = user;
        this.cnt = cnt;
        this.state = state;
        this.isCancel = isCancel;
    }

}
