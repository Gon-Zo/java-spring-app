package com.app.api.domain.product.support;

import com.app.api.web.dto.ProductDto;

public interface ProductSupport {

    void update(long seq , ProductDto.ProductResponse dto);
}
