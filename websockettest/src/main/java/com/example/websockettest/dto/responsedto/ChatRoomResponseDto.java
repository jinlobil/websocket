package com.example.websockettest.dto.responsedto;

import com.example.websockettest.model.ChatRoom;
import com.example.websockettest.model.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class ChatRoomResponseDto {

    private Long id;
    private String chatRoomName;
    private String nickname;

    public ChatRoomResponseDto(ChatRoom chatRoom, User user) {
        this.id = chatRoom.getId();
        this.chatRoomName = chatRoom.getChatRoomName();
        this.nickname = user.getNickname();
    }
}
