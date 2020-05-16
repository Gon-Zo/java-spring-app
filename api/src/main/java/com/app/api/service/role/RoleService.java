package com.app.api.service.role;


import com.app.api.domain.role.Role;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.RoleResponseDto;
import org.springframework.data.domain.Page;

public interface RoleService {

    Page<Role> getPages (PageableDto dto);

    void createRole (RoleResponseDto dto);

    void modifyRole( long seq , RoleResponseDto dto);

    void removeRole(long seq);

    Role getRole(long seq);

}
