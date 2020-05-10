package com.app.api.web.admin;

import com.app.api.domain.role.Role;
import com.app.api.service.role.RoleService;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.RoleResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/admin/role")
public class RoleController {

    private RoleService roleService;

    @GetMapping("")
    public Page<Role> showPages (PageableDto dto){
        return roleService.getPages(dto);
    }

    @PostMapping("")
    public void makeRole (RoleResponseDto dto){
        roleService.createRole(dto);
    }

    @PutMapping("/{seq}")
    public void changeRole (@PathVariable long seq ,  RoleResponseDto dto){
        roleService.modifyRole(seq, dto);
    }

}
