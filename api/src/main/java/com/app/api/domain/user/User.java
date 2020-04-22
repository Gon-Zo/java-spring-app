package com.app.api.domain.user;

import com.app.api.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

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

    @Column(name = "type" ,  nullable = false)
    private String type;

    @Column(name = "img"  , columnDefinition = "TEXT")
    private String img;

    @Column(name = "is_use" ,  nullable = false)
    private Boolean isUse;

//    @OneToOne(mappedBy = "store")
//    private Store store;

//    @Builder
//    public User(String email, String password) {
//        this.email = email;
//        this.password = password;
//    }

    @Builder
    public User(
            String email,
            String password,
            String address,
            LocalDate birthDate,
            String type,
            String img,
            Boolean isUse) {
        this.email = email;
        this.password = password;
        this.address = address;
        this.birthDate = birthDate;
        this.type = type;
        this.img = img;
        this.isUse = isUse;
    }


}
