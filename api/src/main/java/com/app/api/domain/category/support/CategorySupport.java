package com.app.api.domain.category.support;

import com.app.api.domain.category.Category;
import com.app.api.web.dto.CategoryResponseDto;
import com.app.api.web.dto.PageableDto;
import org.springframework.data.domain.Page;

public interface CategorySupport {

    void update(long seq , CategoryResponseDto dto);

    Page<Category> findByPage(PageableDto dto);

}
