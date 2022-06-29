package com.example.websockettest.dto.requestdto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChatRoomRequestDto {

    private String chatRoomName;
    private String nickname;

}