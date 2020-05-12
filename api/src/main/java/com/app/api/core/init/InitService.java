package com.app.api.core.init;

import com.app.api.core.error.exception.BusinessException;
import com.app.api.core.error.exception.ErrorCode;
import com.app.api.domain.menu.Menu;
import com.app.api.domain.menu.MenuRepository;
import com.app.api.domain.role.Role;
import com.app.api.domain.role.RoleRepository;
import com.app.api.domain.url.Url;
import com.app.api.domain.url.UrlRepository;
import com.app.api.domain.user.User;
import com.app.api.domain.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
@Slf4j
public class InitService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final MenuRepository menuRepository;

    private final UrlRepository urlRepository;

    public InitService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       MenuRepository menuRepository,
                       UrlRepository urlRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.menuRepository = menuRepository;
        this.urlRepository = urlRepository;
    }

    public void init() {
        List<Url> urls = initAuthUrl();
        Menu menu = initMenu(urls);
        Role role = initRoles(menu);
        initUser(role);
    }

    private List<Url> initAuthUrl() {

        long cnt = userRepository.count();

        List<Url> urls = new ArrayList<>();

        if (checkIngToSize(cnt)) {

            List<String> list = Arrays.asList(
                    "/admin/url",
                    "/admin/menu",
                    "/admin/menu"
            );

            urls = list.stream().map(m ->
                    urlRepository.saveAndFlush(Url.builder()
                            .title(m)
                            .build()
                    )).collect(Collectors.toList());

        }

        return urls;

    }

    private Menu initMenu(List<Url> urls) {

        long size = menuRepository.count();

        Menu menu = null;

        if (checkIngToSize(size)) {

            menu = menuRepository.saveAndFlush(Menu.builder()
                    .title("Controller")
                    .url("/controller")
                    .icon("faGamepad")
                    .menuOrder(Long.valueOf(999))
                    .authUrl(urls)
                    .build());

        }

        return menu;

    }

    private Role initRoles(Menu menu) {

        long size = roleRepository.count();

        List<Role> roles = new ArrayList<>();

        if (checkIngToSize(size)) {
            List<String> list = Arrays.asList("ADMIN", "MANAGER", "USER");
            roles = list.stream()
                    .map(f -> roleRepository.saveAndFlush(Role.builder()
                            .title(f)
                            .menus(Arrays.asList(menu))
                            .build()))
                    .collect(Collectors.toList());
        }

        if (checkIngToSize(roles.size())) {
            return null;
        }

        return roles.get(0);

    }

    private void initUser(Role role) {

        long size = userRepository.count();

        if (checkIngToSize(size)) {

            userRepository.save(User.builder()
                    .email("admin")
                    .password("1234")
                    .address("")
                    .img("default.jpg")
                    .isUse(Boolean.TRUE)
                    .birthDate(null)
                    .roles(Arrays.asList(role))
                    .build());

        }

    }

    /**
     * Shecking to Entity Size
     *
     * @param size
     * @return
     */
    private Boolean checkIngToSize(long size) {
        return size == 0;
    }

}
