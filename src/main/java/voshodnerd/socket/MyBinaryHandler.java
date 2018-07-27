package voshodnerd.socket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

import java.io.IOException;

@Component
public  class MyBinaryHandler extends BinaryWebSocketHandler {
    public void handleBinaryMessage(WebSocketSession session, BinaryMessage message) {
        try {
           // session.sendMessage(new BinaryMessage("hello world".getBytes()));
            session.sendMessage(new BinaryMessage(message.getPayload().array()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
