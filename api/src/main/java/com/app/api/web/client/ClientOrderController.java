package com.app.api.web.client;

import com.app.api.enums.States;
import com.app.api.service.order.OrderService;
import com.app.api.web.dto.OrderResponseDto;
import org.springframework.web.bind.annotation.*;


/**
 * Create by park031517@gmail.com on 2020-08-13, 목
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@RestController
@RequestMapping("/client/order")
public class ClientOrderController {

    private final OrderService service;

    public ClientOrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping("")
    public void makeOrder(OrderResponseDto dto) {
        service.saveTo(dto);
    }

    @PutMapping("/{seq}")
    public void modifyToIsCancel (@PathVariable long seq , @RequestBody Boolean isCancel ){
        service.updateToIsCancel(seq, isCancel);
    }

    @PutMapping("/{seq}")
    public void modifyToState(@PathVariable long seq, @RequestBody States states) {
        service.updateToState(seq, states);
    }

}
