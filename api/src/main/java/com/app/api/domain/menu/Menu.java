package com.app.api.domain.menu;

import com.app.api.domain.BaseEntity;
import com.app.api.domain.role.Role;
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

    @Column(name = "auth_url", columnDefinition = "TEXT")
    private String authUrl;

    @Column(name = "menu_order")
    private Long menuOrder;

//    @ManyToMany
//    @JoinColumn(name = "role_seq")
//    private List<Role> roles;

}
