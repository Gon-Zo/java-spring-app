package com.app.api.domain.review;

import com.app.api.domain.product.Product;
import com.app.api.domain.user.User;
import com.app.api.util.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "app_review")
public class Review extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Lob
    @Column(name = "content")
    private String content;

    @OneToOne
    private Product product;

    @OneToOne
    private User user;


}
