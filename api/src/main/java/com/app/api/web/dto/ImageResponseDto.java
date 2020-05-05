package com.app.api.web.dto;

import com.app.api.domain.image.Image;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class ImageResponseDto {

    private String photo;

    private String type;

    private Long dataId;

    @Builder
    public ImageResponseDto(String photo, String type, Long dataId) {
        this.photo = photo;
        this.type = type;
        this.dataId = dataId;
    }

    public Image toEntity(){
       return  Image .builder()
               .photo(this.photo)
               .type(this.type)
               .dataId(this.dataId)
               .build();
    }

}
