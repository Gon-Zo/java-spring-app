package com.app.api.domain.role.support;

import com.app.api.domain.role.Role;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.RoleResponseDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RoleSupport {

   Page<Role> findByPages(PageableDto dto);

   void update(long seq, RoleResponseDto dto);

   Role findByTitle(String title);

   List<Role> findByUser(String email);

}
