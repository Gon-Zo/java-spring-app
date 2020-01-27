package com.app.api.domain.posts.support;

import com.app.api.domain.posts.Posts;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class PostsRepositorySupportImpl extends QuerydslRepositorySupport implements PostsRepositorySupport{

    private final EntityManager entityManager;
    private final JPAQueryFactory jpaQueryFactory;

    public PostsRepositorySupportImpl(EntityManager entityManager, JPAQueryFactory jpaQueryFactory) {
        super(Posts.class);
        this.entityManager = entityManager;
        this.jpaQueryFactory = jpaQueryFactory;
    }


}
