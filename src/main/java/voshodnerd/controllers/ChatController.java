package voshodnerd.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import voshodnerd.model.ChatMessage;
import voshodnerd.model.User;

import java.util.Map;

@Controller
public class ChatController {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        System.out.println(chatMessage.toString());
        return chatMessage;
    }

   /* @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public User getUsers(SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        //headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        //headerAccessor.getSessionAttributes()
        //return chatMessage;
    }
*/


    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage,
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;
    }
}
