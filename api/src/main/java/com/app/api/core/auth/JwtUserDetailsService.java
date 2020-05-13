package com.app.api.core.auth;

import com.app.api.domain.role.Role;
import com.app.api.domain.role.support.RoleSupport;
import com.app.api.domain.user.User;
import com.app.api.domain.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

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
        List<Role> roles = roleSupport.findByUser(username);
        User user = userRepository.findByEmail(username);
        user.setRoles(roles);
        UserDetails customUserDetails = user;
        return customUserDetails;
    }

    public List<Role> authRole(String username) throws UsernameNotFoundException {
        return roleSupport.findByUser(username);
    }

}
