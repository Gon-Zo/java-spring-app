package com.app.api.service.order;

import com.app.api.domain.order.Order;
import com.app.api.web.dto.OrderResponseDto;
import com.app.api.web.dto.PageableDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderService {

    List<Order> getByDto(OrderResponseDto dto);

    Order getById(long seq);

    Page<Order> getPages(PageableDto dto);

    void saveBy(OrderResponseDto dto);

    void removeBy(long seq);

}
