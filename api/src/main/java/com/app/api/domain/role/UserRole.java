package com.app.api.domain.role;

import com.app.api.domain.BaseEntity;
import com.app.api.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Getter
@Entity
@NoArgsConstructor
@Table(name = "USERS_ROLE")
public class UserRole extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_seq")
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_seq")
    private Role role;

}
