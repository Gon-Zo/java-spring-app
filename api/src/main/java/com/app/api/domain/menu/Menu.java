package com.app.api.domain.menu;

import com.app.api.domain.BaseEntity;
import com.app.api.domain.url.Url;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "app_menu")
@NoArgsConstructor
public class Menu extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "url")
    private String url ;

    @Column(name = "icon")
    private String icon;

    @Column(name = "menu_order")
    private Long menuOrder;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Url> authUrl;

    @Builder
    public Menu(String title  , String url , String icon , Long menuOrder ) {
        this.title = title;
        this.url = url;
        this.icon = icon;
        this.menuOrder = menuOrder;
    }

}
