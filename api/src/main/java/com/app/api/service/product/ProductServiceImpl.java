package com.app.api.service.product;

import com.app.api.domain.category.Category;
import com.app.api.domain.category.CategoryRepository;
import com.app.api.domain.category.support.CategorySupport;
import com.app.api.domain.product.Product;
import com.app.api.domain.product.ProductRepository;
import com.app.api.domain.product.support.ProductSupport;
import com.app.api.global.error.exception.BusinessException;
import com.app.api.global.error.exception.ErrorCode;
import com.app.api.web.dto.ProductDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

   private final CategoryRepository categoryRepository;

   private final CategorySupport categorySupport;

   private final ProductRepository productRepository;

   private final ProductSupport productSupport;

   @Override
   public void createCategory(ProductDto.CategoryResponse dto) {
      categoryRepository.save(dto.toEntitiy());
   }

   @Override
   public void removeCategory(long seq) {
      categoryRepository.deleteById(seq);
   }

   @Override
   public Category getCategory(long seq) {
      return categoryRepository
              .findById(seq)
              .orElseThrow(()->new BusinessException(ErrorCode.CATEGORY_NOT_FOUND));
   }

   @Override
   @Transactional
   public void updateCategory(long seq, ProductDto.CategoryResponse dto) {
       categorySupport.update(seq, dto);
   }

   @Override
   public List<Category> getCategories() {
      return categoryRepository.findAll();
   }

   @Override
   public void removeProduct(long seq) {
      productRepository.deleteById(seq);
   }

   @Override
   public Product getProduct(long seq) {
      return productRepository.findById(seq)
              .orElseThrow(()-> new BusinessException(ErrorCode.PRODUCT_NOT_FOUND));
   }

   @Override
   public void updateProduct(long seq , ProductDto.ProductResponse dto) {
      productSupport.update(seq, dto);
   }

   @Override
   public void createProduct(ProductDto.ProductResponse dto) {
      productRepository.save(dto.toEntity());
   }

   @Override
   public Page<Product> getProducts(Pageable pageable) {
      return productRepository.findAll(pageable);
   }

}
