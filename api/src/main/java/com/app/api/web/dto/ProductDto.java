package com.app.api.web.dto;

import com.app.api.domain.category.Category;
import com.app.api.domain.product.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

public class ProductDto {

    @Getter
    @ToString
    @NoArgsConstructor
    public static class CategoryResponse{

        private String title;

        private long order;

        public Category toEntitiy() {
            return Category
                    .builder()
                    .title(title)
                    .order(order)
                    .build();
        }

    }

    @Getter
    @ToString
    @NoArgsConstructor
    public static class ProductResponse{

        private String title;
        private Integer cnt;
        private BigDecimal price;
        private String info;
        private Boolean isSold;

        public Product toEntity(){
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

}
