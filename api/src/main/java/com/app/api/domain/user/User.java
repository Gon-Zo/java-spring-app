package com.app.api.domain.user;

import com.app.api.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
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

    @Column(name ="roles" , nullable = false)
    private String roles;

    @Builder
    public User(
            String email,
            String password,
            String address,
            LocalDate birthDate,
            String img,
            Boolean isUse ,
            String roles
            ) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.birthDate = birthDate;
        this.img = img;
        this.isUse = isUse;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
        auth.add(new SimpleGrantedAuthority(roles));
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
