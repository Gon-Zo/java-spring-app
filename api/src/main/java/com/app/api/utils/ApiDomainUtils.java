package com.app.api.utils;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.DatePath;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringPath;
import io.jsonwebtoken.lang.Collections;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ApiDomainUtils {

    /**
     * Oder By Query
     * @param orders
     * @return
     */
    public static List<OrderSpecifier<?>> getOrder(List<String> orders) {
        return orders.stream().map(m -> {
            String[] orderArray = m.split(":");

            String str = orderArray[0];
            String order = orderArray[1];

            OrderSpecifier<?> orderSpecifier = null;

            if (str.contains("At")) {
                DatePath<LocalDate> v = Expressions.datePath(LocalDate.class, str);
                if (order.equals("asc")) {
                    orderSpecifier = v.asc();
                } else {
                    orderSpecifier = v.desc();
                }
            } else {
                StringPath s = Expressions.stringPath(str);
                if (order.equals("asc")) {
                    orderSpecifier = s.asc();
                } else {
                    orderSpecifier = s.desc();
                }
            }
            return orderSpecifier;
        }).collect(Collectors.toList());
    }

    public static boolean isNotEmpty(List<?> list){ return ! Collections.isEmpty(list); } }
