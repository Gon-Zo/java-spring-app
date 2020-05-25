package com.app.api.web.admin;

import com.app.api.domain.role.Role;
import com.app.api.service.role.RoleService;
import com.app.api.web.dto.PageableDto;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/role")
public class AdminRoleController {

    private final RoleService roleService;

    public AdminRoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("")
    public Page<Role> test(PageableDto dto){
        return roleService.getPages(dto);
    }

}
