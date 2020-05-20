package com.app.api.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@ToString
@NoArgsConstructor
public class ChartData {


    private String id;

    private String color;

    private List<Map<String , Object>> data;

    @Builder
    public ChartData(String id, String color, List<Map<String, Object>> data) {
        this.id = id;
        this.color = color;
        this.data = data;
    }

}
