package com.app.api.domain.order.support;

import com.app.api.domain.order.Order;
import com.app.api.web.dto.OrderResponseDto;
import com.app.api.web.dto.PageableDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderSupport {

    List<Order> findBy(OrderResponseDto dto);

    Page<Order> findByPage(PageableDto dto);

}
