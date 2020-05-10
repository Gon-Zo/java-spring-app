package com.app.api.web.dto;

import com.app.api.domain.menu.Menu;
import com.app.api.domain.role.Role;
import com.app.api.domain.url.Url;
import lombok.*;

import java.util.List;

@ToString
@Getter
@NoArgsConstructor
public class RoleResponseDto {

    private String title;

    private List<Long> menuSeq;

    private List<Long> authUrlSeq;

    @Setter private List<Menu> menus;

    @Setter private List<Url> authUrl;

    public Role toEntity() {
        return Role.builder()
                .title(title)
                .menus(menus)
                .authUrl(authUrl)
                .build();
    }

}
