package com.app.api.service.order;

import com.app.api.core.error.exception.BusinessException;
import com.app.api.core.error.exception.ErrorCode;
import com.app.api.domain.order.Order;
import com.app.api.domain.order.OrderRepository;
import com.app.api.domain.order.support.OrderSupport;
import com.app.api.domain.product.ProductRepository;
import com.app.api.domain.user.UserRepository;
import com.app.api.enums.States;
import com.app.api.web.dto.OrderResponseDto;
import com.app.api.web.dto.PageableDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Create by park031517@gmail.com on 2020-08-13, 목
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderSupport support;

    private final OrderRepository repository;

    private final UserRepository userRepository;

    private final ProductRepository productRepository;

    @Override
    public List<Order> getToOrders(OrderResponseDto dto) {

        if (dto.getUserSeq() != 0L) {

            dto.setUser(
                    userRepository
                            .findById(dto.getUserSeq())
                            .orElseThrow(() ->
                                    new BusinessException(ErrorCode.USER_NOT_FOUND))
            );
            return support.findBy(dto);

        } else if (dto.getProductSeq() != 0L) {

            dto.setProduct(
                    productRepository.findById(dto.getProductSeq())
                            .orElseThrow(() -> new BusinessException(ErrorCode.PRODUCT_NOT_FOUND))
            );

            return support.findBy(dto);

        } else {

            return support.findBy(dto);
        }

    }

    @Override
    public Order getToOrder(long seq) {
        return repository
                .findById(seq)
                .orElseThrow(() -> new BusinessException(ErrorCode.ORDER_NOT_FOUND));
    }

    @Override
    public Page<Order> getPages(PageableDto dto) {
        return support.findByPage(dto);
    }

    @Override
    @Transactional
    public void saveTo(OrderResponseDto dto) {

        dto.setUser(userRepository.findById(dto.getUserSeq())
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND)));

        dto.setProduct(productRepository.findById(dto.getProductSeq())
                .orElseThrow(() -> new BusinessException(ErrorCode.PRODUCT_NOT_FOUND)));

        repository.save(dto.toEntity());

    }

    @Override
    @Transactional
    public void removeTo(long seq) {
        repository.deleteById(seq);
    }

    @Override
    @Transactional
    public void updateToState(long seq, States states) {
        Order order = repository.getOne(seq);
        order.setState(states.getValue());
        repository.save(order);
    }

    @Override
    @Transactional
    public void updateToIsCancel(long seq, Boolean isCancel) {
        Order order = repository.getOne(seq);
        order.setIsCancel(isCancel);
        repository.save(order);
    }

}
