package com.app.api.domain.like;

import com.app.api.domain.user.User;
import com.app.api.domain.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "LIKES")
public class Like extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_seq")
    private User user;

    @Column(name = "type")
    private String type;

    @Column(name = "num")
    private Long num;

    @Builder
    public Like(User user  , String type , Long num) {
       this.user = user;
       this.type = type;
       this.num = num;
    }

}
