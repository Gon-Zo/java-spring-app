package com.app.api.domain.user;

import com.app.api.util.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "app_user")
public class User extends BaseEntity {

    @Column(name = "email")
    private String email;

    @Column(name = "passworad")
    private String password;

    @Builder
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
