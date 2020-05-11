package com.app.api.service.menu;

import com.app.api.domain.menu.Menu;
import com.app.api.domain.menu.MenuRepository;
import com.app.api.domain.menu.support.MenuSupport;
import com.app.api.domain.role.RoleRepository;
import com.app.api.domain.role.support.RoleSupport;
import com.app.api.web.dto.MenuResponseDto;
import com.app.api.web.dto.PageableDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        return role.stream()
                .map(m -> roleSupport.findByTitle(m))
                .map(v -> v.getMenus())
                .flatMap(Collection::parallelStream)
                .sorted(Comparator.comparing(Menu::getMenuOrder))
                .collect(Collectors.toList());
    }

    @Override
    public void createMenu(MenuResponseDto dto) {
        menuRepository.save(dto.toEntity());
    }

    @Override
    @Transactional
    public void modifyMenu(long seq, MenuResponseDto dto) {
        menuSupport.update(seq, dto);
    }

    @Override
    @Transactional
    public void remove(long seq) {
        menuRepository.deleteById(seq);
    }

    @Override
    public Page<Menu> getPageMenu(PageableDto dto) {
        return menuSupport.findByPages(dto);
    }

}
