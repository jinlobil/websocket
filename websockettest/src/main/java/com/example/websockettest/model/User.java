package com.example.websockettest.model;

import com.example.websockettest.dto.requestdto.UserRequestDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@NoArgsConstructor
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String nickname;

    @JsonIgnore
    @Column(nullable = false)
    private String password;


    @Column(nullable = false)
    private String profileUrl;

    public User(String username, String nickname, String password, String profileUrl) {
        this.username = username;
        this.nickname = nickname;
        this.password = password;
        this.profileUrl = profileUrl;
    }
    public User(String nickname, String profileUrl) {
        this.nickname = nickname;
        this.profileUrl = profileUrl;
    }

    public User(UserRequestDto userRequestDto) {
        this.username = userRequestDto.getUsername();
        this.nickname = userRequestDto.getNickname();
        this.password = userRequestDto.getPassword();
        this.profileUrl = userRequestDto.getProfileUrl();
    }

    public User(String username, String nickname, String profileUrl){
        this.username = username;
        this.nickname = nickname;
        this.profileUrl = profileUrl;
    }

}