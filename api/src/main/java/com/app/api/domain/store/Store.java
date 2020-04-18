package com.app.api.domain.store;

import com.app.api.domain.user.User;
import com.app.api.util.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "app_store")
public class Store extends BaseEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "phone")
    private String phone;

    @Lob
    @Column(name = "address")
    private String address;

    @Lob
    @Column(name = "img")
    private String img;

    @OneToOne
    private User user;

}
