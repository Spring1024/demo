package com.spring1024.controller;

import java.security.Principal;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

import com.spring1024.bean.chat;
import com.spring1024.bean.landlord;
import com.spring1024.bean.user;
import com.spring1024.service.houseService;
import com.spring1024.service.landlordService;
import com.spring1024.service.userService;
import com.spring1024.util.PageBean;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.spring1024.bean.house;

/**
 * 负责页面与页面之间的跳转，不做处理
 *
 * @author xzc
 */

@Controller
public class userPageController {
    private static ConcurrentHashMap<String, landlord> toList=new ConcurrentHashMap<>();
    @Autowired
    userService userService;
    @Autowired
    houseService houseService;
    @Autowired
    landlordService landlordService;
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    //跳转至首页
    @RequestMapping({"/user/index","/"})
    public ModelAndView skipIndexPage() {
        List<landlord> list=landlordService.queryLandlord();
        for (landlord l:list) {
            toList.put(l.getLname(),l);
        }
        ModelAndView md = new ModelAndView();
        // 获得展示房源
        List<house> hs = houseService.queryHouses();
        md.addObject("hs", hs);
        md.setViewName("/User/index");
        return md;
    }

    //跳转至关于页面
    @RequestMapping(value = "/user/about")
    public String skipAboutPage() {
        return "/User/about";
    }

    //跳转至服务页面
    @RequestMapping(value = "/user/services")
    public ModelAndView skipServicePage(String htype) {
        ModelAndView md = new ModelAndView();

        //默认请求路径
        String url = "/queryByCondition?query=1";

        if (htype != null && !StringUtils.isEmpty(htype)) {
            url += "&htype=" + htype;
        }
        System.out.println(url);
        md.addObject("url", url);
        md.setViewName("/User/services");
        return md;
    }

    //跳转到登录页面
    @RequestMapping(value = "/user/login")
    public String skipLoginPage() {
        return "/User/login";
    }

    @RequestMapping(value = "/chatweb")
    public String toChatWeb(HttpSession session) {
        return "/User/wechat_room";
    }

    //跳转到注册页面
    @RequestMapping(value = "/user/regist")
    public String skipRegistPage() {
        return "/User/regist";
    }

    //登录成功后，跳转到个人主页
    @RequestMapping(value = "/user/login_succ")
    public ModelAndView skipSuccPage(HttpSession session) {
        ModelAndView md = new ModelAndView();
        user user = (user) session.getAttribute("user");
        if(userService.queryCollect(user.getUid())!=null){
            PageBean<house> pb = userService.queryCollect(user.getUid());
            md.addObject("pb", pb);
        }
        md.setViewName("/User/login_succ");
        return md;
    }
    @MessageMapping("/chat")
    public void chat(SecurityUtils securityUtils, chat chat){
        Object obj=securityUtils.getSubject().getPrincipal();
        System.out.println(obj);
        chat.setFrom("1");
        simpMessagingTemplate.convertAndSendToUser(chat.getTo(),"/queue/chat",chat);
    }
}
