package com.app.api.web.client;

import com.app.api.domain.basket.Basket;
import com.app.api.service.basket.BasketService;
import com.app.api.web.dto.BasketRespnseDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/client/basket")
public class ClientBasketController {

    private final BasketService service;

    public ClientBasketController(BasketService service) {
        this.service = service;
    }

    /**
     * 장바구니 저장
     *
     * @param dto
     */
    @GetMapping("")
    public void createBasket (BasketRespnseDto dto){
        service.saveBy(dto);
    }

    /**
     * 장바구니 지우기
     *
     * @param seq
     */
    @DeleteMapping("/{seq}")
    public void removeBasket(@PathVariable @NotNull long seq){
      service.deleteBy(seq);
    }


    /**
     * 장바구니 정보 출력
     * @return
     */
    @GetMapping("/{seq}")
    public Basket showBasket(@PathVariable long seq){
        return service.getBasket(seq);
    }

}
