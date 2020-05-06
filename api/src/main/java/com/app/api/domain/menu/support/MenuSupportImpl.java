package com.app.api.domain.menu.support;

import com.app.api.domain.menu.Menu;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class MenuSupportImpl extends QuerydslRepositorySupport implements MenuSupport {

    public MenuSupportImpl() {
        super(Menu.class);
    }


}
