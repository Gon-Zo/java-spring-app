package com.app.api.domain.user.support;


import com.app.api.domain.user.QUser;
import com.app.api.domain.user.User;
import com.app.api.web.dto.UserRespoenseDto;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static com.app.api.domain.user.QUser.user;
import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;

@Repository
public class UserRepositorySupportImpl extends QuerydslRepositorySupport implements UserRepositorySupport {

    private final EntityManager entityManager;

    private final JPAQueryFactory jpaQueryFactory;

    public UserRepositorySupportImpl(EntityManager entityManager, JPAQueryFactory jpaQueryFactory) {
        super(User.class);
        this.entityManager = entityManager;
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    @Transactional
    public Long update(long seq, UserRespoenseDto dto) {
        return updateQuery(jpaQueryFactory.update(user), dto)
                .where(user.seq.eq(seq))
                .execute();
    }

    private JPAUpdateClause updateQuery(JPAUpdateClause update, UserRespoenseDto dto) {

        if (isNotEmpty(dto.getEmail())) {
            update.set(user.email, dto.getEmail());
        }

        if (isNotEmpty(dto.getPassword())) {
            update.set(user.password, dto.getPassword());
        }

        return update;
    }

}
