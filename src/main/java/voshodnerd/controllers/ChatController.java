package voshodnerd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import voshodnerd.model.ChatMessage;
import voshodnerd.model.ListUsers;
import voshodnerd.model.User;

import java.util.List;


@Controller
public class ChatController {

    @Autowired
    ListUsers listUsers;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        System.out.println(chatMessage.toString());
        return chatMessage;
    }

    @MessageMapping("/chat.getUser")
    @SendTo("/topic/users")
    public List<User> getUsers(SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        //headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        //headerAccessor.getSessionAttributes();
        System.out.println("getUsers here ");
        return listUsers.getListUsers();
        //return chatMessage;
    }



    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        listUsers.addUser(new User(chatMessage.getSender()));

        return chatMessage;
    }
}
