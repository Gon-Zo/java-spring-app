package com.app.api.statics.group;

import com.app.api.statics.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "test_group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long seq;

    @Column(name = "title")
    private String title;

    @Column(name = "info")
    private String info;

    @ManyToMany
    @JoinTable(name = "test_user_group",
            // 상대 컬럼
            joinColumns = @JoinColumn(name = "user_seq"),
            // 본인 컬럼
            inverseJoinColumns = @JoinColumn(name = "group_seq"))
    private List<User> Users = new ArrayList<User>();

}
