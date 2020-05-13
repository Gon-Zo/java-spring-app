package com.app.api.domain.review;

import com.app.api.domain.image.Image;
import com.app.api.domain.product.Product;
import com.app.api.domain.user.User;
import com.app.api.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "REVIEWS")
public class Review extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "content" , columnDefinition = "TEXT")
    private String content;

    @OneToOne
    private Product product;

    @OneToOne
    private User user;

    @OneToMany
    private List<Image> images;

    @Builder
    public Review(String title, String content, Product product, User user, List<Image> images) {
        this.title = title;
        this.content = content;
        this.product = product;
        this.user =  user;
        this.images = images;
    }

}
