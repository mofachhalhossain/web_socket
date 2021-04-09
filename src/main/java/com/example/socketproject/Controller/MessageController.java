package com.example.socketproject.Controller;

import com.example.socketproject.Model.MessageModel;
import com.example.socketproject.Storage.User;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController{

    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat/{to}")
    public void sendMessage(@DestinationVariable String to, MessageModel message){
        System.out.println("handling send message: " +message+ "to" + to );
        boolean isExists = User.getInstance().getUsers().contains(to);
        if(isExists){
            simpMessagingTemplate.convertAndSend("/topic/messages" +to, message);
        }

    }
}
