package com.app.api.web.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDto {

    private static final long serialVersionUID = 5926468583005150707L;

    private String email;

    private String password;

}
