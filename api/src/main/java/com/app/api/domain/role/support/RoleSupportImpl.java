package com.app.api.domain.role.support;

import com.app.api.domain.role.Role;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static com.app.api.domain.role.QRole.role;

@Repository
public class RoleSupportImpl extends QuerydslRepositorySupport implements RoleSupport {

    private final EntityManager entityManager;
    private final JPAQueryFactory jpaQueryFactory;

    public RoleSupportImpl(EntityManager entityManager, JPAQueryFactory jpaQueryFactory) {
        super(Role.class);
        this.entityManager = entityManager;
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    @Transactional
    public Role findByTitle(String title) {
        return jpaQueryFactory.selectFrom(role).where(role.title.eq(title)).fetchOne();
    }

}
