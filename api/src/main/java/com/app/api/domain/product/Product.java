package com.app.api.domain.product;

import com.app.api.domain.image.Image;
import com.app.api.domain.store.Store;
import com.app.api.util.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "app_product")
public class Product extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "cnt")
    private Integer cnt;

    @Column(name = "price")
    private BigDecimal price;

    @Lob
    @Column(name = "info")
    private String info;

    @Column(name = "isSold")
    private Boolean isSold;

    @ManyToOne
    @JoinColumn(name = "store_seq")
    private Store store;

    @OneToMany
    private List<Image> images;

}
