package com.app.api.service.product;

import com.app.api.domain.category.Category;
import com.app.api.domain.product.Product;
import com.app.api.web.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    void createCategory (ProductDto.CategoryResponse dto);

    void removeCategory(long seq);

    Category getCategory(long seq);

    void updateCategory(long seq , ProductDto.CategoryResponse dto);

    List<Category> getCategories();

    void removeProduct(long seq);

    Product getProduct(long seq);

    void updateProduct(long seq, ProductDto.ProductResponse dto);

    void createProduct(ProductDto.ProductResponse dto);

    Page<Product> getProducts (Pageable pageable);

}
