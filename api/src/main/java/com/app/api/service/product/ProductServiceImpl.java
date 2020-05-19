package com.app.api.service.product;

import com.app.api.domain.product.Product;
import com.app.api.domain.product.ProductRepository;
import com.app.api.domain.product.support.ProductSupport;
import com.app.api.core.error.exception.BusinessException;
import com.app.api.core.error.exception.ErrorCode;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.ProductResponseDto;
import com.querydsl.core.Tuple;
import lombok.AllArgsConstructor;
import org.springframework.aop.scope.ScopedObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductSupport support;

    @Override
    public List<Map<String, Object>> getChartData() {

        List<Tuple> list = support.findGroupByTitle();

        Map<Object, List<Map<String, Object>>> collect = list.stream().map(f -> {
            Map<String, Object> m = new HashMap<>();
            String title = f.get(0, String.class);
            LocalDate createAt = f.get(1, LocalDate.class);
            Integer val = f.get(2, Integer.class);
            m.put("title", title);
            m.put("createAt", createAt);
            m.put("val", val);
            return m;
        }).collect(Collectors.groupingBy(g -> g.get("createAt")));

        Iterator<Object> keys = collect.keySet().iterator();

        while (keys.hasNext()){

            List<Map<String, Object>> temp = collect.get(keys);

            temp.stream().map(m ->{

                m.get("title");

                m.get("createAt");

                m.get("val");

            });


        }

         return null;

    }

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
