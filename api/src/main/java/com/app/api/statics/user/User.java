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

//    @JoinTable(name = "test_user_group",
//            joinColumns = @JoinColumn(name = "group_seq"),
//            inverseJoinColumns = @JoinColumn(name = "user_seq"))
//    private List<Group> groups = new ArrayList<Group>();

}
