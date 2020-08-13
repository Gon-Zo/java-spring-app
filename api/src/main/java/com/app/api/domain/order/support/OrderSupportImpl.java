package com.app.api.domain.order.support;

import com.app.api.domain.order.Order;
import com.app.api.web.dto.OrderResponseDto;
import com.app.api.web.dto.PageableDto;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import static com.app.api.domain.order.QOrder.order;

/**
 * Create by park031517@gmail.com on 2020-08-13, 목
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Repository
public class OrderSupportImpl extends QuerydslRepositorySupport implements OrderSupport {
kkkkkkkkk
    private final JPAQueryFactory jpaQueryFactory;

    public OrderSupportImpl(JPAQueryFactory jpaQueryFactory) {
        super(Order.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> findBy(OrderResponseDto dto) {
        return jpaQueryFactory.selectFrom(order).where(whereQuery(dto)).fetch();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Order> findByPage(PageableDto dto) {

        JPAQuery<Order> query = jpaQueryFactory
                .selectFrom(order);

        Pageable pageable = PageRequest.of(dto.getPage(), dto.getSize());

        query.offset(pageable.getOffset()).limit(pageable.getPageSize());

        QueryResults<Order> fetchResults = query.fetchResults();

        long total = fetchResults.getTotal();

        List<Order> results = fetchResults.getResults();

        return new PageImpl<>(results , pageable , total);
    }

    private BooleanBuilder whereQuery(OrderResponseDto dto) {

        BooleanBuilder bb = new BooleanBuilder();

        if (ObjectUtils.isNotEmpty(dto.getUser())) {
            bb.and(order.user.eq(dto.getUser()));
        }

        if (ObjectUtils.isNotEmpty(dto.getProduct())) {
            bb.and(order.product.eq(dto.getProduct()));
        }

        return bb;

    }

}
