package com.app.api.domain.category.support;

import com.app.api.web.dto.CategoryResponseDto;

public interface CategorySupport {

    void update(long seq , CategoryResponseDto dto);
}
