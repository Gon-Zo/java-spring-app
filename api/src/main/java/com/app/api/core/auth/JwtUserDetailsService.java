package com.app.api.core.auth;

import com.app.api.domain.role.Role;
import com.app.api.domain.user.User;
import com.app.api.domain.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public JwtUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails customUserDetails = userRepository.findByEmail(username);
        return customUserDetails;
    }

    public List<Role> loadUserRoles (String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        return user.getRoles();
    }

}
