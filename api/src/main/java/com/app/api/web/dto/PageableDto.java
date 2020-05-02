package com.app.api.web.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class PageableDto {

    private int size;

    private int page;

    private List<String> sort;

    @Builder
    public PageableDto(int size, int page, List<String> sort) {
        this.size = size;
        this.page = page;
        this.sort = sort;
    }

}
