package com.app.api.statics.user.impl;

import com.app.api.statics.user.QUser;
import com.app.api.statics.user.User;
import com.app.api.statics.user.UserRepositorySuport;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class UserRepositorySuportImpl extends QuerydslRepositorySupport implements UserRepositorySuport {

    private final EntityManager entityManager;
    private final JPAQueryFactory jpaQueryFactory;


    public UserRepositorySuportImpl(EntityManager entityManager, JPAQueryFactory jpaQueryFactory) {
        super(User.class);
        this.entityManager = entityManager;
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public User findByTitle(String title) {
        QUser user = QUser.user;
        return jpaQueryFactory.selectFrom(user).where(user.title.eq(title)).fetchOne();
    }

}
