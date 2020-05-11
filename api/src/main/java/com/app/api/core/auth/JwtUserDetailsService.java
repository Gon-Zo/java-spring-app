package com.app.api.core.auth;

import com.app.api.domain.role.support.RoleSupport;
import com.app.api.domain.url.Url;
import com.app.api.domain.user.User;
import com.app.api.domain.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    private final RoleSupport roleSupport;

    public JwtUserDetailsService(UserRepository userRepository, RoleSupport roleSupport) {
        this.userRepository = userRepository;
        this.roleSupport = roleSupport;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails customUserDetails = userRepository.findByEmail(username);
        return customUserDetails;
    }

    public List<Url> authRoleUrl(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        return user.getRoles().stream()
                .map(m -> m.getMenus())
                .flatMap(Collection::parallelStream)
                .map(m -> m.getAuthUrl())
                .flatMap(Collection::parallelStream)
                .collect(Collectors.toList());
    }

}
