package com.app.api.domain.store;

import com.app.api.domain.user.User;
import com.app.api.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Create by park031517@gmail.com on 2020-08-19, 수
 * Blog : https://zzz-oficial.tistory.com
 * Github : https://github.com/Gon-Zo
 */
@Getter
@NoArgsConstructor
@Entity
@Table(name = "STORES")
public class Store extends BaseEntity {

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "account_number")
    private String accountNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_seq")
    private User user;

    @Builder
    public Store(String name , String accountNumber ,  User user) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.user = user;
    }

}
