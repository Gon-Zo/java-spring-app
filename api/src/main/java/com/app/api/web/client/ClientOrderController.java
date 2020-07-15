package com.app.api.web.client;

import com.app.api.service.order.OrderService;
import com.app.api.web.dto.OrderResponseDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/client/order")
public class ClientOrderController {

    private final OrderService service;

    public ClientOrderController(OrderService service) {
        this.service = service;
    }

    /**
     * 주문 신청
     *
     * @param dto
     */
    @PostMapping("")
    public void makeOrder(OrderResponseDto dto) {
        service.saveBy(dto);
    }

    /**
     * 주문 취소
     *
     * @param seq
     */
    @DeleteMapping("/{seq}")
    public void cancelOrder(@PathVariable @NotNull long seq) {
        service.removeBy(seq);
    }

}
