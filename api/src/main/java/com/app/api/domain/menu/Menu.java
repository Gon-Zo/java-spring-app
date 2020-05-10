package com.app.api.domain.menu;

import com.app.api.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @Builder
    public Menu(String title  , String url , String icon , Long menuOrder ) {
        this.title = title;
        this.url = url;
        this.icon = icon;
        this.menuOrder = menuOrder;
    }

}
