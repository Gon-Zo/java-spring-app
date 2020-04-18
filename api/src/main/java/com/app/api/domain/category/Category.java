package com.app.api.domain.category;

import com.app.api.domain.product.Product;
import com.app.api.util.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "app_category")
public class Category extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "_order")
    private Long order;

    @OneToMany
    @JoinColumn(name = "seq")
    private List<Product> products;

}
