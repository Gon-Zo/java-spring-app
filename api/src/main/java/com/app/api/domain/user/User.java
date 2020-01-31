package com.app.api.domain.user;

import com.app.api.core.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
// todo : table name change - jkpark
@Table(name = "app_user")
public class User extends BaseEntity {

    @Column(name = "email")
    private String email;

    @Column(name = "passworad")
    private String password;

}
