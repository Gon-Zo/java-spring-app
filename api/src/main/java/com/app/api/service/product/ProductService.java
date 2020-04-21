package com.app.api.service.product;

import com.app.api.domain.product.Product;
import com.app.api.web.dto.ProductResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProductService {

    void removeProduct(long seq);

    Product getProduct(long seq);

    void updateProduct(long seq, ProductResponseDto dto);

    void createProduct(ProductResponseDto dto);

    Page<Product> getProducts (Pageable pageable);

}
