package com.app.api.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ApiDateUtils {

    public static LocalDate fomratting(String yyyyMMdd) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        LocalDate localDate = LocalDate.parse(yyyyMMdd, dateTimeFormatter);
    
        return localDate;

    }

}
