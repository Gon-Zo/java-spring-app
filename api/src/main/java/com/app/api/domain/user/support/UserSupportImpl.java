package com.app.api.domain.user.support;

import com.app.api.domain.role.QRole;
import com.app.api.domain.role.Role;
import com.app.api.domain.user.User;
import com.app.api.utils.ApiDomainUtils;
import com.app.api.web.dto.LoginResponseDto;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.UserRespoenseDto;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.app.api.domain.user.QUser.user;

import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;
import static com.app.api.utils.ApiDomainUtils.isNotEmpty;

@Repository
public class UserSupportImpl extends QuerydslRepositorySupport implements UserSupport {

    private final EntityManager entityManager;

    private final JPAQueryFactory jpaQueryFactory;

    public UserSupportImpl(EntityManager entityManager, JPAQueryFactory jpaQueryFactory) {
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
    public Optional<User> findByUser(LoginResponseDto dto) {
        return Optional
                .ofNullable(
                        jpaQueryFactory
                                .selectFrom(user)
                                .where(
                                        user.email.eq(dto.getEmail()).and(user.password.eq(dto.getPassword()))
                                )
                                .fetchOne()
                );

    }

    @Override
    public Page<User> findByUsers(PageableDto dto) {

        List<Role> roles = new ArrayList<>();

        JPAQuery<User> query = jpaQueryFactory
                .selectFrom(user);

        if (isNotEmpty(dto.getSort())) {
            query.orderBy(ApiDomainUtils.getOrder(dto.getSort()).toArray(new OrderSpecifier[0]));
        }

        PageRequest pageable = PageRequest.of(dto.getPage(), dto.getSize());

        query.limit(pageable.getPageSize()).offset(pageable.getOffset());

        QueryResults<User> fetchResult = query.fetchResults();

        long total = fetchResult.getTotal();

        List<User> results = fetchResult.getResults();

        return new PageImpl<>(results, pageable, total);

    }

    @Override
    public User findByEmail(String email) {
        return jpaQueryFactory.selectFrom(user).where(user.email.eq(email)).fetchOne();
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

        if (ObjectUtils.isNotEmpty(dto.getBirthDate())){
            update.set(user.birthDate  , dto.getBirthDate());
        }

        if (isNotEmpty(dto.getAddress())) {
            update.set(user.address , dto.getAddress());
        }

        if (isNotEmpty(dto.getImg())) {
            update.set(user.img , dto.getImg());
        }

        if (ObjectUtils.isNotEmpty(dto.getIsUse())){
            update.set(user.isUse, dto.getIsUse());
        }

        return update;
    }

}
