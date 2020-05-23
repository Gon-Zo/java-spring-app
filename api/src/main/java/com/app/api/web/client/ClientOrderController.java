package com.app.api.web.client;

import com.app.api.service.order.OrderService;
import com.app.api.web.dto.OrderResponseDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client/order")
public class ClientOrderController {

    private final OrderService service;

    public ClientOrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping("")
    public void orderedProduct(OrderResponseDto dto){
       service.saveBy(dto);
    }

    @DeleteMapping("/{seq}")
    public void cancelOrder(@PathVariable long seq) {
        service.removeBy(seq);
    }

}
