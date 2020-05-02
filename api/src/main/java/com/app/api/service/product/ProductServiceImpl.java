package com.app.api.service.product;

import com.app.api.domain.product.Product;
import com.app.api.domain.product.ProductRepository;
import com.app.api.domain.product.support.ProductSupport;
import com.app.api.core.error.exception.BusinessException;
import com.app.api.core.error.exception.ErrorCode;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.ProductResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductSupport support;

    @Override
    public void removeProduct(long seq) {
        repository.deleteById(seq);
    }

    @Override
    public Product getProduct(long seq) {
        return repository.findById(seq)
                .orElseThrow(
                        () -> new BusinessException(ErrorCode.PRODUCT_NOT_FOUND)
                );
    }

    @Override
    public void updateProduct(long seq , ProductResponseDto dto) {
        support.update(seq, dto);
    }

    @Override
    public void createProduct(ProductResponseDto dto) {
        repository.save(dto.toEntity());
    }

    @Override
    public Page<Product> getProducts(PageableDto dto) {
        return support.findByProducts(dto);
    }

}
