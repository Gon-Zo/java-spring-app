package com.app.api.web.dto;

import com.app.api.domain.like.Like;
import com.app.api.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class LikeResponseDto {

    private long userSeq;

    private long num;

    private String type;

    @Setter
    private User user;

    public LikeResponseDto(int userSeq, long num, String type) {
        this.userSeq = userSeq;
        this.num = num;
        this.type = type;
    }

    public Like toEntity(){
        return Like.builder()
                .user(user)
                .num(num)
                .type(type)
                .build();
    }

}
