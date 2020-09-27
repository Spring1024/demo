package com.spring1024.controller;

import com.spring1024.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
public class test {

    private static String userName = "x";
    private static String landlordName = "z";

    @RequestMapping("/wechat")
    public String wechat() {
        return "/User/wechat_room";
    }

    /*消息群发，接受发送至自massRequest的请求*/
    //SendTo 发送至 Broker 下的指定订阅路径mass ,
    // Broker再发送消息到订阅了/mass的用户
    @MessageMapping("/massRequest")
    @SendTo("/mass")
    public ChatRoomResponse mass(ChatRoomRequest chatRoomRequest) {
        System.out.println("fromName = " + chatRoomRequest.getFromName()
                + " ChatValue = " + chatRoomRequest.getChatValue());
        ChatRoomResponse response = new ChatRoomResponse();
        response.setFromName(chatRoomRequest.getFromName());
        response.setChatValue(chatRoomRequest.getChatValue());
        return response;
    }


    /*Spring实现的一个发送模板类*/
    @Autowired
    private SimpMessagingTemplate template;

    /*单独聊天，接受发送至自aloneRequest的请求*/
    @MessageMapping("/aloneRequest")
    public void alone(ChatRoomRequest chatRoomRequest) {
        if (landlordName.equals(chatRoomRequest.getFromName())) {
            System.out.println("SendToUser = " + userName
                    + " FromName = " + chatRoomRequest.getFromName()
                    + " ChatValue = " + chatRoomRequest.getChatValue());
            ChatRoomResponse response = new ChatRoomResponse();
            response.setFromName(chatRoomRequest.getFromName());
            response.setChatValue(chatRoomRequest.getChatValue());
            template.convertAndSendToUser(userName + ""
                    , "/alone", response);
        } else {
            System.out.println("SendToUser = " + chatRoomRequest.getToUserId()
                    + " FromName = " + chatRoomRequest.getFromName()
                    + " ChatValue = " + chatRoomRequest.getChatValue());
            ChatRoomResponse response = new ChatRoomResponse();
            response.setFromName(chatRoomRequest.getFromName());
            response.setChatValue(chatRoomRequest.getChatValue());
            if (!userName.equals(landlordName)) {
                userName = chatRoomRequest.getFromName();
                landlordName = chatRoomRequest.getToUserId();
                System.out.println(userName + landlordName);
            }

            //发送到订阅了 /queue/{用户的id}/alone 的用户处
            template.convertAndSendToUser(chatRoomRequest.getToUserId() + ""
                    , "/alone", response);

        }
    }
}
