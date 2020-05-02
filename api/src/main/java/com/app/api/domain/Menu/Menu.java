package com.app.api.domain.Menu;

import com.app.api.domain.BaseEntity;
import com.app.api.domain.role.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
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

    @ManyToMany
    private List<Role> roles;

}
