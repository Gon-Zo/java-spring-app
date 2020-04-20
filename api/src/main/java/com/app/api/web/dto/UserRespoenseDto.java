package com.app.api.web.dto;

import com.app.api.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class  UserRespoenseDto {

    private long seq;
    private String email;
    private String password;

    @Builder
    public UserRespoenseDto( long seq , String email, String password) {
        this.seq = seq;
        this.email = email;
        this.password = password;
    }

    public User toEntity() {
        return User.builder()
                .email(this.email)
                .password(this.password)
                .build();
    }

}
