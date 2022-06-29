package com.example.websockettest.dto.responsedto;

import lombok.Getter;

@Getter
public class LoginResponseDto {

    private String nickname;
    private String profileUrl;

    private String letter;
    private String username;

    public LoginResponseDto(String username, String nickname, String profileUrl, String letter) {
        this.username = username;
        this.nickname = nickname;
        this.profileUrl = profileUrl;
        this.letter = letter;
    }
}
