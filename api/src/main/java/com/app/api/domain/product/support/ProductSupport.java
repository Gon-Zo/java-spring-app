package com.app.api.domain.product.support;

import com.app.api.domain.product.Product;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.ProductResponseDto;
import com.querydsl.core.Tuple;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductSupport {

    void update(long seq , ProductResponseDto dto);

    Page<Product> findByProducts (PageableDto dto , boolean isClient);

    List<Tuple> findGroupByTitle();

}
