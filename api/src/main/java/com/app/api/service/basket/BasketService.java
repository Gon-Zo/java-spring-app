package com.app.api.service.basket;

import com.app.api.domain.basket.Basket;
import com.app.api.web.dto.BasketRespnseDto;

public interface BasketService {

    void saveBy(BasketRespnseDto dto);

    void deleteBy(long seq);

    Basket getBasket(long seq);

}
