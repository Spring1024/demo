package com.spring1024.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
/*开启使用Stomp协议来传输基于消息broker的消息
这时控制器支持使用@MessageMapping,就像使用@RequestMapping一样*/
@EnableWebSocketMessageBroker
public class webSocketConfig implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        /*注册STOMP协议的节点(endpoint),并映射指定的url,
         * 添加一个访问端点“/endpointMark”,客户端打开双通道时需要的url,
         * 允许所有的域名访问，指定使用SockJS协议。*/
        registry.addEndpoint("/endpointMark")
                .setAllowedOrigins("*")
                .withSockJS();

    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        /*配置消息代理*/
        registry.enableSimpleBroker("/mass","/queue");

        /*一对一访问时，给用户信息时增加发送地址的前缀*/
        registry.setUserDestinationPrefix("/queue");
    }
}
