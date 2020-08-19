package com.app.api.domain.menu.support;

import com.app.api.domain.menu.Menu;
import com.app.api.web.dto.MenuDto;
import com.app.api.web.dto.PageableDto;
import org.springframework.data.domain.Page;

public interface MenuSupport {

    Page<Menu> findByPages(PageableDto dto);

    void update( long seq , MenuDto dto);

}
