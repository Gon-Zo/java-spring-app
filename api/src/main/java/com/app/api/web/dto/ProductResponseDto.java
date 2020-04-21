package com.app.api.web.dto;

import com.app.api.domain.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@ToString
@NoArgsConstructor
public class ProductResponseDto {

    private String title;
    private Integer cnt;
    private BigDecimal price;
    private String info;
    private Boolean isSold;

    public Product toEntity() {
        return Product
                .builder()
                .title(title)
                .cnt(cnt)
                .price(price)
                .info(info)
                .isSold(isSold)
                .build();
    }

}
