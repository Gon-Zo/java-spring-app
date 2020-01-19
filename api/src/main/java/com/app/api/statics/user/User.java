package com.app.api.statics.user;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Entity
@Table(name = "test_user")
public class User {
    @Id
    // auto seq
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long seq;
    @Column(name = "title")
    private String title;
}
