package com.app.api.domain.order.support;

import com.app.api.domain.order.Order;
import com.app.api.domain.product.QProduct;
import com.app.api.web.dto.OrderResponseDto;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import static com.app.api.domain.order.QOrder.order;

@Repository
public class OrderSupportImpl extends QuerydslRepositorySupport implements OrderSupport {

    private final JPAQueryFactory jpaQueryFactory;

    public OrderSupportImpl(JPAQueryFactory jpaQueryFactory) {
        super(Order.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<Order> findBy(OrderResponseDto dto) {
        return jpaQueryFactory.selectFrom(order).where(whereQuery(dto)).fetch();
    }

    /**
     * where query
     *
     * @param dto
     * @return
     */
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

    public void test(){

        List<Expressions> select = new ArrayList<>();

        List<Order> list = jpaQueryFactory
                .select(Projections.fields(Order.class, select.toArray(new Expression[0])))
                .from(order)
                .innerJoin(QProduct.product)
                .on(order.product.seq.eq(QProduct.product.seq))
                .groupBy(order.createdAt, QProduct.product.title)
                .fetch();

    }

}
