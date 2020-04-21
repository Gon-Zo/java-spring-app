package com.app.api.domain.product.support;

import com.app.api.domain.product.Product;
import com.app.api.web.dto.ProductResponseDto;
import com.querydsl.core.dml.UpdateClause;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import static com.app.api.domain.product.QProduct.product;
import static org.apache.commons.lang3.ObjectUtils.isNotEmpty;

@Repository
public class ProductSupportImpl extends QuerydslRepositorySupport  implements ProductSupport {

    private final JPAQueryFactory jpaQueryFactory;

    private final EntityManager  entityManager;

    public ProductSupportImpl(JPAQueryFactory jpaQueryFactory, EntityManager entityManager) {
        super(Product.class);
        this.jpaQueryFactory = jpaQueryFactory;
        this.entityManager = entityManager;
    }

    @Override
    public void update(long seq, ProductResponseDto dto) {
        UpdateClause<JPAUpdateClause> update = update(product);

        if (isNotEmpty(dto.getTitle())) {
            update.set(product.title, dto.getTitle());
        }

        if (isNotEmpty(dto.getCnt())) {
            update.set(product.cnt, dto.getCnt());
        }

        if (isNotEmpty(dto.getPrice())) {
            update.set(product.price, dto.getPrice());
        }

        if (isNotEmpty(dto.getInfo())) {
            update.set(product.info, dto.getInfo());
        }

        if (isNotEmpty(dto.getIsSold())) {
            update.set(product.isSold, dto.getIsSold());
        }

        update.where(product.seq.eq(seq)).execute();
    }

}
