package com.app.api.domain.category.support;

import com.app.api.web.dto.ProductDto;

public interface CategorySupport {

    void update(long seq , ProductDto.CategoryResponse dto);
}
