package com.app.api.service.menu;

import com.app.api.domain.menu.Menu;
import com.app.api.domain.menu.MenuRepository;
import com.app.api.domain.menu.support.MenuSupport;
import com.app.api.domain.role.Role;
import com.app.api.domain.role.RoleRepository;
import com.app.api.domain.role.support.RoleSupport;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<Menu> getAuthMenu(List<String> role) {

        return roleSupport.findByTitles(role).stream()
                .map(m->m.getMenus())
                .flatMap(Collection::parallelStream)
                .sorted(Comparator.comparing(Menu::getMenuOrder))
                .collect(Collectors.toList());

    }

}
