package com.app.api.domain.question;

import com.app.api.domain.image.Image;
import com.app.api.domain.product.Product;
import com.app.api.domain.user.User;
import com.app.api.util.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Getter
@Entity
@NoArgsConstructor
@Table(name = "app_quetion")
public class Question extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Lob
    @Column(name = "content")
    private String content;

    @Column(name = "isLock")
    private Boolean isLock;

    @OneToOne
    private User user;

    @OneToMany
    private List<Image> images;

}
