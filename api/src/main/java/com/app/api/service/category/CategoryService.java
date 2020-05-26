package com.app.api.service.category;

import com.app.api.domain.category.Category;
import com.app.api.web.dto.CategoryResponseDto;
import com.app.api.web.dto.PageableDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {

    void createCategory (CategoryResponseDto dto);

    void removeCategory(long seq);

    Category getCategory(long seq);

    void updateCategory(long seq , CategoryResponseDto dto);

    List<Category> getCategories();

    Page<Category> getPages(PageableDto dto);

}
