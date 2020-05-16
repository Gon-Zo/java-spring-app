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

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("")
    public Page<Role> showPages (PageableDto dto){
        return roleService.getPages(dto);
    }

    @GetMapping("/{seq}")
    public Role showRole(@PathVariable long seq){
        return roleService.getRole(seq);
    }

    @PostMapping("")
    public void makeRole (RoleResponseDto dto){
        roleService.createRole(dto);
    }

    @PutMapping("/{seq}")
    public void changeRole (@PathVariable long seq ,  RoleResponseDto dto){
        roleService.modifyRole(seq, dto);
    }

    @DeleteMapping("/{seq}")
    public void redPencilRole(@PathVariable long seq){
       roleService.removeRole(seq);
    }

}
