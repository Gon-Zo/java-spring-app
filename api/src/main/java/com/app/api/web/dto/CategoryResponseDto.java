package com.app.api.web.dto;

//import com.app.api.domain.category.Category;
import com.app.api.domain.category.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class CategoryResponseDto {

    private String title;

    private long order;

    public Category toEntitiy() {
        return Category
                .builder()
                .title(title)
                .order(order)
                .build();
    }

}
