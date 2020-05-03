package com.app.api.domain.order.support;

import com.app.api.domain.order.Order;
import com.app.api.web.dto.OrderResponseDto;

import java.util.List;

public interface OrderSupport {

    List<Order> findBy(OrderResponseDto dto);

}
