package com.app.api.domain.role.support;

import com.app.api.domain.role.Role;

public interface RoleSupport {

   Role findByTitle(String title);

}
