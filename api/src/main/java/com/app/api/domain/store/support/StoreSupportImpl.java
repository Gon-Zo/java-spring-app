package com.app.api.domain.store.support;

import com.app.api.domain.store.Store;
import com.app.api.web.dto.StoreRepoenseDto;

import com.querydsl.core.dml.UpdateClause;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import static com.app.api.domain.store.QStore.store;

@Repository
public class StoreSupportImpl extends QuerydslRepositorySupport implements StoreSupport {

        private final JPAQueryFactory jpaQueryFactory;

        private final EntityManager entityManager;


        public StoreSupportImpl(JPAQueryFactory jpaQueryFactory, EntityManager entityManager) {
                super(Store.class);
                this.jpaQueryFactory = jpaQueryFactory;
                this.entityManager = entityManager;
        }

        @Override
        public void update(long seq, StoreRepoenseDto dto) {

                UpdateClause<JPAUpdateClause> update = update(store);

                String title = dto.getTitle();
                if(ObjectUtils.isNotEmpty(title)){
                        update.set(store.title , title);
                }

                String address = dto.getAddress();
                if (ObjectUtils.isNotEmpty(address)) {
                        update.set(store.address, address);
                }

                String img = dto.getImg();
                if(ObjectUtils.isNotEmpty(img)){
                        update.set(store.img , img );
                }

                String phone = dto.getPhone();
                if (ObjectUtils.isNotEmpty(phone)) {
                        update.set(store.phone, phone);
                }

                update.where(store.seq.eq(seq)).execute();

        }

}
