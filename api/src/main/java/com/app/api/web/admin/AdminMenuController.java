package com.app.api.web.admin;

import com.app.api.domain.menu.Menu;
import com.app.api.service.menu.MenuService;
import com.app.api.web.dto.MenuResponseDto;
import com.app.api.web.dto.PageableDto;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/menu")
public class AdminMenuController {

    private final MenuService menuService;

    public AdminMenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("")
    public Page<Menu> showPageMenu(PageableDto dto){
        return menuService.getPageMenu(dto);
    }

    @PostMapping("")
    public void makeMenu(MenuResponseDto dto){
        menuService.createMenu(dto);
    }

    @PutMapping("/{seq}")
    public void updateInfoMenu(@PathVariable long seq  , MenuResponseDto dto){
        menuService.modifyMenu(seq, dto);
    }

    @DeleteMapping("/{seq}")
    public void removeMenu(@PathVariable long seq){
        menuService.remove(seq);
    }

}
