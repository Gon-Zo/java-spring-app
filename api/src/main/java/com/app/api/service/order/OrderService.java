package com.app.api.service.order;

import com.app.api.domain.order.Order;
import com.app.api.enums.States;
import com.app.api.web.dto.OrderResponseDto;
import com.app.api.web.dto.PageableDto;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Create by park031517@gmail.com on 2020-08-13, 목
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
public interface OrderService {

    List<Order> getToOrders(OrderResponseDto dto);

    Order getToOrder(long seq);

    Page<Order> getPages(PageableDto dto);

    void saveTo(OrderResponseDto dto);

    void removeTo(long seq);

    void updateToState( long seq , States states);

    void updateToIsCancel(long seq , Boolean isCancel);

}
