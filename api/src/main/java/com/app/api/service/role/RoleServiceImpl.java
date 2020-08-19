package com.app.api.service.role;

import com.app.api.core.error.exception.BusinessException;
import com.app.api.core.error.exception.ErrorCode;
import com.app.api.domain.menu.MenuRepository;
import com.app.api.domain.role.Role;
import com.app.api.domain.role.RoleRepository;
import com.app.api.domain.role.support.RoleSupport;
import com.app.api.domain.url.UrlRepository;
import com.app.api.web.dto.PageableDto;
import com.app.api.web.dto.RoleDto;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private RoleSupport roleSupport;

    private RoleRepository roleRepository;

    private MenuRepository menuRepository;

    private UrlRepository urlRepository;

    @Override
    public Page<Role> getPages(PageableDto dto) {
        return roleSupport.findByPages(dto);
    }

    @Override
    public void createRole(RoleDto dto) {

        dto.getMenuSeq()
                .stream()
                .forEach(f -> dto.getMenus()
                                .add(menuRepository.findById(f)
                                        .orElseThrow(() -> new BusinessException(ErrorCode.MENUN_NOT_FOUND))));

        roleRepository.save(dto.toEntity());

    }

    @Override
    public void modifyRole( long seq , RoleDto dto) {
        roleSupport.update(seq , dto);
    }

    @Override
    @Transactional
    public void removeRole(long seq) {
        roleRepository.findById(seq);
    }

    @Override
    public Role getRole(long seq) {
        return roleRepository.findById(seq).orElseThrow(() -> new BusinessException(ErrorCode.AUTH_NOT_ROLES));
    }

}
