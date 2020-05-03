package com.app.api.service.order;

import com.app.api.domain.order.Order;
import com.app.api.web.dto.OrderResponseDto;

import java.util.List;

public interface OrderService {

    List<Order> getByDto(OrderResponseDto dto);
    Order getById(long seq);

}
