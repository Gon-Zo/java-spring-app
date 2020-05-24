package com.app.api.domain.basket.support;

import com.app.api.domain.basket.Basket;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class BasketSupportImpl extends QuerydslRepositorySupport implements BasketSupport {

    private final JPAQueryFactory jpaQueryFactory;

    public BasketSupportImpl(JPAQueryFactory jpaQueryFactory) {
        super(Basket.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

}
