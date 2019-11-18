package com.dxy.zidane.common.web.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author dxy
 * @date 2019/11/18 10:33
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myHandler(), "myHandler/{ID}")
                .setAllowedOrigins("*").addInterceptors(new WebSocketInterceptor());
    }


    public WebSocketHandler myHandler() {
        return new MyHandler();
    }

}