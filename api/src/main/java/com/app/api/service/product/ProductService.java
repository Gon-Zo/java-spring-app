package com.app.api.service.product;

import com.app.api.domain.product.Product;
import com.app.api.web.dto.ChartData;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.ProductResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;


public interface ProductService {

    List<ChartData> getChartData();

    void removeProduct(long seq);

    Product getProduct(long seq);

    void updateProduct(long seq, ProductResponseDto dto);

    void createProduct(ProductResponseDto dto);

    Page<Product> getProducts (PageableDto dto , boolean isClient);

}
