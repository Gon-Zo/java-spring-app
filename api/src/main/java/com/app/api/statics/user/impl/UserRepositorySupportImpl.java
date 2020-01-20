package com.app.api.statics.user.impl;

import com.app.api.statics.user.User;
import com.app.api.statics.user.UserRepositorySupport;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Transient;

import static com.app.api.statics.user.QUser.user;

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
        return jpaQueryFactory.selectFrom(user).where(user.title.eq(title)).fetchOne();
    }

    /**
     * update to user
     *
     * @param obj
     */
    @Override
    @Transient
    public void update(User obj) {
        jpaQueryFactory.update(user)
                .set(user.title, obj.getTitle()).execute();
    }

    /**
     * delete to seq
     *
     * @param seq
     */
    @Override
    @Transient
    public void deleteBy(long seq) {
        jpaQueryFactory.delete(user)
                .where(user.seq.eq(seq))
                .execute();
    }


}
