package voshodnerd;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;
import voshodnerd.socket.MyBinaryHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
      //  registry.addHandler(new MyTextHandler(), "/text").withSockJS();
        registry.addHandler(new MyBinaryHandler(), "/binary").setAllowedOrigins("*").withSockJS();
    }




}