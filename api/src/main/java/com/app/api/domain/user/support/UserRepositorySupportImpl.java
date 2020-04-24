package com.app.api.domain.user.support;


import com.app.api.domain.user.User;
import com.app.api.web.dto.LoginViewModel;
import com.app.api.web.dto.UserRespoenseDto;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.Optional;

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
    public Optional<Long> update(long seq, UserRespoenseDto dto) {
        return Optional.ofNullable(updateQuery(jpaQueryFactory.update(user), dto)
                .where(user.seq.eq(seq))
                .execute());
    }

    @Override
    public Optional<User> findByUser(LoginViewModel dto) {
        return Optional
                .ofNullable(
                        (User) jpaQueryFactory
                                .selectFrom(user)
                                .where(
                                        user.email.eq(dto.getEmail()).and(user.password.eq(dto.getPassword()))
                                )
                                .fetchOne()
                );

    }

    /**
     * udpate query setting
     * @param update
     * @param dto
     * @return
     */
    private JPAUpdateClause updateQuery(JPAUpdateClause update, UserRespoenseDto dto) {

        if (isNotEmpty(dto.getEmail())) {
            update.set(user.email, dto.getEmail());
        }

        if (isNotEmpty(dto.getPassword())) {
            update.set(user.password, dto.getPassword());
        }

        return update;
    }


    private BooleanBuilder booleanBuilder (UserRespoenseDto dto){
        BooleanBuilder bb = new BooleanBuilder();
        if(isNotEmpty(dto.getEmail())){
            bb.and(user.email.eq(dto.getEmail()));
        }
        if(isNotEmpty(dto.getPassword())){
            bb.and(user.password.eq(dto.getPassword()));
        }
        return bb;
    }

}
