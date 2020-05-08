package com.app.api.service.menu;

import com.app.api.domain.menu.Menu;

import java.util.List;


public interface MenuService {

    List<Menu> getAuthMenu(List<String> role);

}
