package com.app.api.web.dto;

import com.app.api.domain.menu.Menu;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
public class MenuResponseDto {

    private String title;

    private String url;

    private String icon;

    private Long menuOrder;

    public Menu toEntity(){
       return  Menu.builder()
               .title(title)
               .url(url)
               .icon(icon)
               .menuOrder(menuOrder)
               .build();
    }

}
