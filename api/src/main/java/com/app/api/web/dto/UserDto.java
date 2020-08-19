package com.app.api.web.dto;

import com.app.api.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDate;

@Getter
@ToString
@NoArgsConstructor
public class UserDto {

    private long seq;
    private String email;
    private String password;
    private LocalDate birthDate;
    private String address;
    private String img;
    private Boolean isUse;

    @Builder
    public UserDto(long seq , String email, String password) {
        this.seq = seq;
        this.email = email;
        this.password = password;
    }

    public User toEntity() {
        return User.builder()
                .email(this.email)
                .password(this.password)
                .address(this.address)
                .birthDate(this.birthDate)
                .img(this.img)
                .isUse(this.isUse)
                .build();
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
