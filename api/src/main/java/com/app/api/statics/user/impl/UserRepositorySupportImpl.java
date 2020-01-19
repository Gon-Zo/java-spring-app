package com.app.api.statics.user.impl;

import com.app.api.statics.user.QUser;
import com.app.api.statics.user.User;
import com.app.api.statics.user.UserRepositorySupport;
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

    /**
     * find by title
     *
     * @param title
     * @return User
     */
    @Override
    public User findByTitle(String title) {
        QUser user = QUser.user;
        return jpaQueryFactory.selectFrom(user).where(user.title.eq(title)).fetchOne();
    }

}
