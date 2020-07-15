package com.app.api.service.product;

import com.app.api.domain.product.Product;
import com.app.api.domain.product.ProductRepository;
import com.app.api.domain.product.support.ProductSupport;
import com.app.api.core.error.exception.BusinessException;
import com.app.api.core.error.exception.ErrorCode;
import com.app.api.web.dto.ChartData;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.ProductResponseDto;
import com.querydsl.core.Tuple;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    private final ProductSupport support;

    @Override
    public List<ChartData> getChartData() {

        List<Tuple> list = support.findGroupByTitle();

        Map<Object, List<Map<String, Object>>> collect = list.stream().map(f -> {
            Map<String, Object> m = new HashMap<>();
            m.put("title", f.get(0, String.class));
            m.put("createAt", f.get(1, LocalDate.class));
            m.put("val", f.get(2, Integer.class));
            return m;
        }).collect(Collectors.groupingBy(g -> g.get("title")));

        Iterator<Object> keys = collect.keySet().iterator();

        List<ChartData> chartData = new ArrayList<>();

        while (keys.hasNext()){

            Object o = keys.next();

            List<Map<String, Object>> temp = collect.get(o);

            chartData.add(ChartData.builder()
                    .id(String.valueOf(o))
                    .data(temp)
                    .build());

        }

        return chartData;
    }
@Override
    @Transactional
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
    @Transactional
    public void updateProduct(long seq , ProductResponseDto dto) {
        support.update(seq, dto);
    }

    @Override
    public void createProduct(ProductResponseDto dto) {
        repository.save(dto.toEntity());
    }

    @Override
    public Page<Product> getProducts(PageableDto dto, boolean isClient) {
        return support.findByProducts(dto , isClient);
    }

}
