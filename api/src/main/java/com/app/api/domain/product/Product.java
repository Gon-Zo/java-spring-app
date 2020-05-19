package com.app.api.domain.product;

import com.app.api.domain.image.Image;
import com.app.api.domain.store.Store;
import com.app.api.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "PRODUCTS")
public class Product extends BaseEntity {

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "cnt", nullable = false)
    private Integer cnt;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "info", columnDefinition = "TEXT", nullable = false)
    private String info;

    @Column(name = "is_sold", nullable = false)
    private Boolean isSold;

    @ManyToOne
    @JoinColumn(name = "store_seq", nullable = false)
    private Store store;

    @OneToMany
    private List<Image> images;

    @Builder
    public Product(String title, Integer cnt, BigDecimal price, String info, Boolean isSold) {
        this.title = title;
        this.cnt = cnt;
        this.price = price;
        this.info = info;
        this.isSold = isSold;
    }

}
