package com.app.api.domain.product.support;

import com.app.api.domain.product.Product;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.ProductResponseDto;
import org.springframework.data.domain.Page;

public interface ProductSupport {

    void update(long seq , ProductResponseDto dto);

    Page<Product> findByProducts (PageableDto dto);

}
