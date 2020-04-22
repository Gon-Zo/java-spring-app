package com.app.api.domain.store;

import com.app.api.domain.user.User;
import com.app.api.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "app_store")
public class Store extends BaseEntity {

    @Column(name = "title" , nullable = false)
    private String title;

    @Column(name = "phone" , nullable = false)
    private String phone;

    @Column(name = "address" , nullable = false , columnDefinition = "TEXT")
    private String address;

    @Column(name = "img"  , nullable = false , columnDefinition = "TEXT")
    private String img;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_seq")
    private User user;

    @Builder
    public Store(String title, String phone, String address, String img , User user) {
        this.title = title;
        this.phone = phone;
        this.address = address;
        this.img = img;
        this.user = user;
    }

}
