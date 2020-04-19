package com.app.api.domain.review.Support;

import com.app.api.domain.review.Review;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.persistence.EntityManager;

public class ReviewSupportImpl extends QuerydslRepositorySupport implements ReviewSupport {

    private final JPAQueryFactory jpaQueryFactory;

    private final EntityManager  entityManager;

    public ReviewSupportImpl( JPAQueryFactory jpaQueryFactory, EntityManager entityManager) {
        super(Review.class);
        this.jpaQueryFactory = jpaQueryFactory;
        this.entityManager = entityManager;
    }

}
