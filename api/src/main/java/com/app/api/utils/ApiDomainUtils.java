package com.app.api.utils;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.DatePath;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.StringPath;
import io.jsonwebtoken.lang.Collections;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Create by park031517@gmail.com on 2020-08-13, 목
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
public class ApiDomainUtils {

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

    public static boolean isNotEmpty(List<?> list){ return ! Collections.isEmpty(list); }

    public static boolean notStartWith(String str , String str2){
        return !str.startsWith(str2);
    }
    
    public static boolean isNotContains(String str1, String str2) {
        return !str1.contains(str2);
    }

    public static boolean isNotTrue(Boolean b){
        return !b;
    }

}



