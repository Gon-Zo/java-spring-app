package com.app.api.service.menu;

import com.app.api.domain.menu.Menu;
import com.app.api.domain.menu.MenuRepository;
import com.app.api.domain.menu.support.MenuSupport;
import com.app.api.domain.role.RoleRepository;
import com.app.api.domain.role.support.RoleSupport;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuSupport menuSupport;

    private final MenuRepository menuRepository;

    private final RoleSupport roleSupport;

    private final RoleRepository roleRepository;

    public MenuServiceImpl(MenuSupport menuSupport,
                           MenuRepository menuRepository,
                           RoleSupport roleSupport,
                           RoleRepository roleRepository) {
        this.menuSupport = menuSupport;
        this.menuRepository = menuRepository;
        this.roleSupport = roleSupport;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Menu> getAuthMenu(String role) {
        return roleSupport.findByTitle(role).getMenus();
    }

}
