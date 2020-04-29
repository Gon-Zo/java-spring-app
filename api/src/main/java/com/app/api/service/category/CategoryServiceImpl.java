package com.app.api.service.category;

import com.app.api.domain.category.Category;
import com.app.api.domain.category.CategoryRepository;
import com.app.api.domain.category.support.CategorySupport;
import com.app.api.core.error.exception.BusinessException;
import com.app.api.core.error.exception.ErrorCode;
import com.app.api.web.dto.CategoryResponseDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    private final CategorySupport support;

    public CategoryServiceImpl(CategoryRepository repository, CategorySupport support) {
        this.repository = repository;
        this.support = support;
    }

    @Override
    public void createCategory(CategoryResponseDto dto) {
        repository.save(dto.toEntitiy());
    }

    @Override
    public void removeCategory(long seq) {
        repository.deleteById(seq);
    }

    @Override
    public Category getCategory(long seq) {
        return repository
                .findById(seq)
                .orElseThrow(() -> new BusinessException(ErrorCode.CATEGORY_NOT_FOUND));
    }

    @Override
    @Transactional
    public void updateCategory(long seq, CategoryResponseDto dto) {
        support.update(seq, dto);
    }

    @Override
    public List<Category> getCategories() {
        return repository.findAll();
    }

}
