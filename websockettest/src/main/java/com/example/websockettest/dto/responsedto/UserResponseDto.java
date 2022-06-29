package com.example.websockettest.dto.responsedto;

import lombok.Getter;

@Getter
public class UserResponseDto {
    private String username;
    private String nickname;
    private String profileUrl;
    private String message;

    public UserResponseDto(String username, String nickname, String profileUrl, String message) {
        this.username = username;
        this.nickname = nickname;
        this.profileUrl = profileUrl;
        this.message = message;
    }


}
