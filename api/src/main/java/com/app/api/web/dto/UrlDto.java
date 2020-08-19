package com.app.api.web.dto;

import com.app.api.domain.url.Url;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class UrlDto {

    private String title;

    public Url toEntity() {
        return Url.builder()
                .title(this.title)
                .build();
    }

}
