package com.example.websockettest.dto.requestdto;

import com.example.websockettest.model.ChatMessage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessageRequestDto {

    private ChatMessage.MessageType type;
    private String roomId;
    private String nickname;
    private String sender;
    private String message;
    private String createdAt;
}