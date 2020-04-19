package com.app.api.domain.order.support;

import com.app.api.domain.order.Order;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class OrderSupportImpl extends QuerydslRepositorySupport  implements OrderSupport {

    private final JpaRepositoryFactory  jpaRepositoryFactory;

    public OrderSupportImpl(JpaRepositoryFactory jpaRepositoryFactory) {
        super(Order.class);
        this.jpaRepositoryFactory = jpaRepositoryFactory;
    }

}
