package com.app.api.domain.like.support;

import com.app.api.domain.like.Like;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@Repository
public class LikeSupportImpl extends QuerydslRepositorySupport  implements LikeSupport {

    private final JPAQueryFactory jpaQueryFactory;

    public LikeSupportImpl(JPAQueryFactory jpaQueryFactory) {
        super(Like.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

}
