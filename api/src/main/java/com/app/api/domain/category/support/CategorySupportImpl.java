package com.app.api.domain.category.support;

import com.querydsl.jpa.JPQLQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class CategorySupportImpl extends QuerydslRepositorySupport implements CategorySupport {

    private final JPQLQueryFactory jpqlQueryFactory;

    public CategorySupportImpl(Class<?> domainClass, JPQLQueryFactory jpqlQueryFactory) {
        super(domainClass);
        this.jpqlQueryFactory = jpqlQueryFactory;
    }

}
