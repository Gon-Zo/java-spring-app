package com.app.api.statics.user;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
//@NoArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
