package com.app.api.web.manager;

import com.app.api.domain.order.Order;
import com.app.api.service.order.OrderService;
import com.app.api.web.dto.OrderResponseDto;
import com.app.api.web.dto.PageableDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manager/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService service;

    @GetMapping("/{seq}")
    public Order showOrder (@PathVariable long seq){
       return service.getById(seq);
    }

    @GetMapping("/")
    public List<Order> getOrders (OrderResponseDto dto){
        return service.getByDto(dto);
    }

    @GetMapping("")
    public Page<Order> showPages(PageableDto dto){
       return service.getPages(dto);
    }

}
