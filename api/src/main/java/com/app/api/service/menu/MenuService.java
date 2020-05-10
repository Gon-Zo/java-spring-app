package com.app.api.service.menu;

import com.app.api.domain.menu.Menu;
import com.app.api.web.dto.MenuResponseDto;
import com.app.api.web.dto.PageableDto;
import org.springframework.data.domain.Page;

import java.util.List;


public interface MenuService {

    List<Menu> getAuthMenu(List<String> role);

    void createMenu(MenuResponseDto dto);

    void modifyMenu(long seq , MenuResponseDto dto);

    void remove(long seq);

    Page<Menu> getPageMenu(PageableDto dto);

}
