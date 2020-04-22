package com.app.api.domain.category.support;

import com.app.api.domain.category.Category;
import com.app.api.web.dto.CategoryResponseDto;
import com.querydsl.core.dml.UpdateClause;
import com.querydsl.jpa.JPQLQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import static com.app.api.domain.category.QCategory.category;
import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;

@Repository
public class CategorySupportImpl extends QuerydslRepositorySupport implements CategorySupport {

    private final JPQLQueryFactory jpqlQueryFactory;

    public CategorySupportImpl( JPQLQueryFactory jpqlQueryFactory) {
        super(Category.class);
        this.jpqlQueryFactory = jpqlQueryFactory;
    }

    @Override
    public void update(long seq, CategoryResponseDto dto) {

        UpdateClause<JPAUpdateClause> update = update(category);

        if(isNotEmpty(dto.getTitle())){
            update.set(category.title, dto.getTitle());
        }

        if(isNotEmpty(dto.getOrder())){
            update.set(category.order, dto.getOrder());
        }

        update.where(category.seq.eq(seq)).execute();

    }

}
