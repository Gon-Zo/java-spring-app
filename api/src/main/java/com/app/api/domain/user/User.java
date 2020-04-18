package com.app.api.domain.user;

import com.app.api.util.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "app_users")
public class User extends BaseEntity {

    @Column(name = "email")
    private String email;

    @Column(name = "passworad")
    private String password;

    @Column(name = "birthDate")
    private LocalDate birthDate;

    @Lob
    @Column(name = "address")
    private String address;

    @Column(name = "type")
    private String type;

    @Lob
    @Column(name = "img")
    private String img;

    @Column(name = "isUse")
    private Boolean isUse;

    @Builder
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
