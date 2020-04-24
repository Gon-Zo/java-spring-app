package com.app.api.domain.user;

import com.app.api.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "app_users")
public class User extends BaseEntity {

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
    private String roles = "";

    @Column(name = "permissions" , nullable = false)
    private String permissions = "";

    @Column(name = "user_name", nullable = false)
    private String userName;

    public List<String> getPermissionList(){
        if(this.permissions.length()>0){
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }

    public List<String> getRoleList(){
        if(this.roles.length()>0){
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }

//
//    /**
//     *
//     * USER
//     * ADMIN
//     * MANAGER
//     *
//     */
//    @Column(name = "role" , nullable = false)
//    private String role;

    @Builder
    public User(
            String email,
            String password,
            String address,
            LocalDate birthDate,
            String img,
            Boolean isUse ,
            String roles ,
            String permissions , String userName) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.birthDate = birthDate;
        this.img = img;
        this.isUse = isUse;
        this.roles = roles;
        this.permissions = permissions;
        this.userName = userName;
    }

}
