package com.app.api.web.dto;

import com.app.api.domain.menu.Menu;
import com.app.api.domain.url.Url;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@NoArgsConstructor
public class MenuDto {

    private String title;

    private String url;

    private String icon;

    private Long menuOrder;

    private List<Long> urlSeq;

    @Setter private List<Url> authUrl;

    public Menu toEntity(){
       return  Menu.builder()
               .title(title)
               .url(url)
               .icon(icon)
               .menuOrder(menuOrder)
               .authUrl(authUrl)
               .build();
    }

}
