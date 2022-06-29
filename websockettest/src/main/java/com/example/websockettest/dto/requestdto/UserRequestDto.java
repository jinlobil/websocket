package com.example.websockettest.dto.requestdto;

import lombok.Getter;


@Getter
public class UserRequestDto {


    private String username;

    private String nickname;
    private String password;
    private String passwordCheck;
    private String profileUrl;
}

