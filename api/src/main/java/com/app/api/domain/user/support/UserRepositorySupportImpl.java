package com.app.api.domain.user.support;


import com.app.api.domain.user.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserRepositorySupportImpl extends QuerydslRepositorySupport implements UserRepositorySupport {

    private final EntityManager entityManager;

    private final JPAQueryFactory jpaQueryFactory;

    public UserRepositorySupportImpl(EntityManager entityManager, JPAQueryFactory jpaQueryFactory) {
        super(User.class);
        this.entityManager = entityManager;
        this.jpaQueryFactory = jpaQueryFactory;
    }

}
