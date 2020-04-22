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

    @Column(name = "email")
    private String email;

    @Column(name = "passworad")
    private String password;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "address"  , columnDefinition = "TEXT")
    private String address;

    @Column(name = "type")
    private String type;

    @Column(name = "img"  , columnDefinition = "TEXT")
    private String img;

    @Column(name = "is_use")
    private Boolean isUse;

//    @OneToOne(mappedBy = "store")
//    private Store store;

    @Builder
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
