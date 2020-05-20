package com.app.api.web.manager;

import com.app.api.domain.product.Product;
import com.app.api.service.product.ProductService;
import com.app.api.web.dto.ChartData;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.ProductResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/manager/product")
@AllArgsConstructor
public class ProductController {

    private ProductService service;

    @PostMapping("")
    public void makeProduct(ProductResponseDto dto){
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
    public Page<Product> showProds(PageableDto dto){
        return service.getProducts(dto);
    }

    @GetMapping("/chart")
    public List<ChartData> showChartData() {
        return service.getChartData();
    }

}
