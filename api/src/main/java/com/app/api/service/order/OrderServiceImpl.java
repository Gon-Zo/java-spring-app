package com.app.api.service.order;

import com.app.api.core.error.exception.BusinessException;
import com.app.api.core.error.exception.ErrorCode;
import com.app.api.domain.order.Order;
import com.app.api.domain.order.OrderRepository;
import com.app.api.domain.order.support.OrderSupport;
import com.app.api.domain.product.ProductRepository;
import com.app.api.domain.user.UserRepository;
import com.app.api.web.dto.OrderResponseDto;
import com.app.api.web.dto.PageableDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderSupport support;

    private final OrderRepository repository;

    private final UserRepository userRepository;

    private final ProductRepository productRepository;

    @Override
    public List<Order> getByDto(OrderResponseDto dto) {

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
    public Order getById(long seq) {
        return repository
                .findById(seq)
                .orElseThrow(()-> new BusinessException(ErrorCode.ORDER_NOT_FOUND));
    }

    @Override
    public Page<Order> getPages(PageableDto dto) {
        return support.findByPage(dto);
    }

    @Override
    public void saveBy(OrderResponseDto dto) {

        dto.setUser(userRepository.findById(dto.getUserSeq())
                .orElseThrow(() -> new BusinessException(ErrorCode.USER_NOT_FOUND)));

        dto.setProduct(productRepository.findById(dto.getProductSeq())
                .orElseThrow(() -> new BusinessException(ErrorCode.PRODUCT_NOT_FOUND)));

        repository.save(dto.toEntity());

    }

    @Override
    public void removeBy(long seq) {
        repository.deleteById(seq);
    }





}
