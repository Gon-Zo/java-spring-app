package com.app.api.domain.role;

import com.app.api.domain.BaseEntity;
import com.app.api.domain.menu.Menu;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "app_role")
public class Role extends BaseEntity {

    @Column(name = "title")
    private String title;

    @ManyToMany(fetch= FetchType.EAGER)
    private List<Menu> menus;

}
