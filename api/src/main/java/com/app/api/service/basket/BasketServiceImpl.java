package com.app.api.service.basket;

import com.app.api.core.error.exception.BusinessException;
import com.app.api.core.error.exception.ErrorCode;
import com.app.api.domain.basket.Basket;
import com.app.api.domain.basket.BasketRepository;
import com.app.api.domain.basket.support.BasketSupport;
import com.app.api.domain.product.ProductRepository;
import com.app.api.domain.user.UserRepository;
import com.app.api.web.dto.BasketRespnseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class BasketServiceImpl implements BasketService {

    private final BasketSupport support;

    private final BasketRepository repository;

    private final ProductRepository productRepository;

    private final UserRepository userRepository;

    @Override
    public void saveBy(BasketRespnseDto dto) {

        dto.setUser(userRepository.findById(dto.getUserSeq())
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND)));

        dto.setProduct(productRepository.findById(dto.getProductSeq())
                .orElseThrow(() -> new BusinessException(ErrorCode.PRODUCT_NOT_FOUND)));

        repository.save(dto.toEntity());

    }

    @Override
    @Transactional
    public void deleteBy(long seq) {
        repository.deleteById(seq);
    }

    @Override
    public Basket getBasket(long seq) {
        return repository.findById(seq).orElseThrow(()->new BusinessException(ErrorCode.BASKET_NOT_FOUND));
    }

}
