package com.app.api.domain.role.support;

import com.app.api.domain.role.Role;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.List;

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
    public List<Role> findByTitles(List<String> titles) {
        return jpaQueryFactory.selectFrom(role)
                .where(role.title.in(titles)).fetch();
    }

}
