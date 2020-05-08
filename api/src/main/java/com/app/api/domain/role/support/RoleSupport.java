package com.app.api.domain.role.support;

import com.app.api.domain.role.Role;

import java.util.List;

public interface RoleSupport {

   List<Role> findByTitles(List<String> titles);

}
