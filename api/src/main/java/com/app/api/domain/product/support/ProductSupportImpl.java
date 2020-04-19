package com.app.api.domain.product.support;

import com.app.api.domain.product.Product;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.persistence.EntityManager;

public class ProductSupportImpl extends QuerydslRepositorySupport  implements ProductSupport {

    private final JPAQueryFactory jpaQueryFactory;

    private final EntityManager  entityManager;

    public ProductSupportImpl(JPAQueryFactory jpaQueryFactory, EntityManager entityManager) {
        super(Product.class);
        this.jpaQueryFactory = jpaQueryFactory;
        this.entityManager = entityManager;
    }

}
