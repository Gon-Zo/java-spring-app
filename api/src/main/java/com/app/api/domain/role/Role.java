package com.app.api.domain.role;

import com.app.api.domain.BaseEntity;
import com.app.api.domain.menu.Menu;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "app_role")
public class Role extends BaseEntity {

    @Column(name = "title")
    private String title;

    @ManyToMany
    private List<Menu> menus;

}
