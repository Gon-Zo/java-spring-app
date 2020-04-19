package com.app.api.domain.store.support;

import com.app.api.domain.store.Store;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import javax.persistence.EntityManager;

public class StoreSupportImpl extends QuerydslRepositorySupport implements StoreSupport{

        private final JPAQueryFactory jpaQueryFactory;

        private final EntityManager entityManager;


        public StoreSupportImpl( JPAQueryFactory jpaQueryFactory, EntityManager entityManager) {
                super(Store.class);
                this.jpaQueryFactory = jpaQueryFactory;
                this.entityManager = entityManager;
        }
}
