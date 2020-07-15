package com.app.api.web.client;

import com.app.api.domain.product.Product;
import com.app.api.service.product.ProductService;
import com.app.api.web.dto.PageableDto;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client/product")
public class ClientProductController {

    private final ProductService service;

    public ClientProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("")
    public Page<Product> showProduct(PageableDto dto){
       return service.getProducts(dto , Boolean.TRUE);
    }

}
