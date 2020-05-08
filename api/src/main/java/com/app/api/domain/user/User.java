package com.app.api.domain.user;

import com.app.api.domain.BaseEntity;
import com.app.api.domain.role.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "app_users")
public class User extends BaseEntity  implements UserDetails {

    @Column(name = "email" , nullable = false)
    private String email;

    @Column(name = "passworad" ,  nullable = false)
    private String password;

    @Column(name = "birth_date",  nullable = false)
    private LocalDate birthDate;

    @Column(name = "address"  , columnDefinition = "TEXT" ,  nullable = false)
    private String address;

    @Column(name = "img"  , columnDefinition = "TEXT")
    private String img;

    @Column(name = "is_use" ,  nullable = false)
    private Boolean isUse;

    @Builder
    public User(
            String email,
            String password,
            String address,
            LocalDate birthDate,
            String img,
            Boolean isUse
            ) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.birthDate = birthDate;
        this.img = img;
        this.isUse = isUse;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
        roles.stream().forEach(f -> auth.add(new SimpleGrantedAuthority(f.getTitle())));
        return auth;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
