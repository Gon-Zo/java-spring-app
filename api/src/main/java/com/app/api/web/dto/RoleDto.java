package com.app.api.web.dto;

import com.app.api.domain.menu.Menu;
import com.app.api.domain.role.Role;
import com.app.api.domain.url.Url;
import lombok.*;

import java.util.List;

@ToString
@Getter
@NoArgsConstructor
public class RoleDto {

    private String title;

    private List<Long> menuSeq;

    @Setter private List<Menu> menus;

    public Role toEntity() {
        return Role.builder()
                .title(title)
                .menus(menus)
                .build();
    }

}
