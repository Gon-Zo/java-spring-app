package com.app.api.domain.basket.support;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class BasketSupportImpl extends QuerydslRepositorySupport implements BasketSupport {


    private final JPAQueryFactory jpaQueryFactory;

    public BasketSupportImpl(Class<?> domainClass, JPAQueryFactory jpaQueryFactory) {
        super(domainClass);
        this.jpaQueryFactory = jpaQueryFactory;
    }

}
