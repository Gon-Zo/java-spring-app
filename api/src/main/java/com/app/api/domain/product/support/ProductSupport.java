package com.app.api.domain.product.support;

import com.app.api.web.dto.ProductResponseDto;

public interface ProductSupport {

    void update(long seq , ProductResponseDto dto);
}
