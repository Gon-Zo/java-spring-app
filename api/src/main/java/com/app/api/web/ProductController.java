package com.app.api.web;

import com.app.api.domain.product.Product;
import com.app.api.service.product.ProductService;
import com.app.api.web.dto.ProductResponseDto;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("")
    public void makeProdcut(ProductResponseDto dto){
        service.createProduct(dto);
    }

    @PutMapping("")
    public void updateInfo(long seq , ProductResponseDto dto){
        service.updateProduct(seq, dto);
    }

    @DeleteMapping("/{seq}")
    public void removeProd(@PathVariable long seq){
        service.removeProduct(seq);
    }

    @GetMapping("/{seq}")
    public Product showProd(@PathVariable long seq) {
        return service.getProduct(seq);
    }

    @GetMapping("")
    public Page<Product> showProds(
            @PageableDefault(size = 10, page = 0, sort = "seq", direction = Sort.Direction.ASC)
            Pageable pageable){
        return service.getProducts(pageable);
    }

}
