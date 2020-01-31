package com.app.api.domain.user;

import com.app.api.util.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseEntity {

    @Column(name = "email")
    private String email;

    @Column(name = "passworad")
    private String password;

}
