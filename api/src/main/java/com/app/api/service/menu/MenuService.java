package com.app.api.service.menu;

import com.app.api.domain.menu.Menu;
import com.app.api.web.dto.MenuDto;
import com.app.api.web.dto.PageableDto;
import org.springframework.data.domain.Page;

import java.util.List;


public interface MenuService {

    List<Menu> getAuthMenu(List<String> role);

    void createMenu(MenuDto dto);

    void modifyMenu(long seq , MenuDto dto);

    void remove(long seq);

    Page<Menu> getPageMenu(PageableDto dto);

}
