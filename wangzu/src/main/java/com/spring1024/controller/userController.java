package com.spring1024.controller;

import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.spring1024.bean.collect;
import com.spring1024.bean.house;
import com.spring1024.bean.user;
import com.spring1024.service.userService;
import com.spring1024.util.Message;
import com.spring1024.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "/user")
public class userController {
    @Autowired
    private userService userService;

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @RequestMapping("forRegist")
    public ModelAndView addUser(user user, HttpSession session) {
        ModelAndView md = new ModelAndView();
        System.out.println(user);
        try {
            session.setAttribute("user", user);
            PageBean<house> pb = userService.queryCollect(user.getUid());
            md.addObject("pb", pb);
            md.setViewName("/User/login_succ");
            return md;
        } catch (Exception e) {
            md.setViewName("/User/index");
            e.printStackTrace();
            return md;
        }
    }

    /**
     * 用户更改信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/changeUser")
    public boolean updateUser(@RequestBody Map<String,String> map) {
        try {
            if(map!=null){
                map.remove("oldpwd");
                user user=new user();
                user.setUid(map.get("uid"));
                user.setUtel(Long.parseLong(map.get("utel")));
                user.setUname(map.get("uname"));
                user.setUpwd(map.get("upwd"));
                user.setEmail(map.get("email"));
                userService.updateUser(user);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 用户登录
     *
     * @param user
     * @param session
     * @return
     */
    @RequestMapping(value = "forLogin")
    public ModelAndView login(user user, HttpSession session) {
        ModelAndView md = new ModelAndView();
        String msgErr;
        if (userService.logincheck(user) != null) {
            user = userService.logincheck(user);
            PageBean<house> pb = userService.queryCollect(user.getUid());
            session.setAttribute("user", user);
            md.addObject("pb", pb);
            md.addObject("user", user);
            md.setViewName("/User/login_succ");
            return md;
        } else {
            msgErr = "账号或密码错误！";
            md.addObject("msg", msgErr);
            md.setViewName("/User/login");
            return md;
        }
    }


    /**
     * 校验验证码的正确性
     *
     * @param
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/checkVcode")
    public Boolean checkVcode(HttpServletRequest request, HttpSession session) {
        String vcode = request.getParameter("vcode");
        // 得到session中存储的验证码
        String code = (String) session.getAttribute("vCode");
        // 判断
        if (vcode == null || !(vcode.equalsIgnoreCase(code))) {
            return false;
        } else {
            return true;
        }
    }

	/**
	 * 判断电话号码是否被注册 注册进行的判断，注册了需要提示
	 *
	 * @param
     *             utel
	 *            登陆的电话号码
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "checkutel")
	public Message checkUteleIsExist(String utel) {
		Message mess = null;
		try {
			userService.checkutel(utel);
			mess = new Message("", "flase");
		} catch (Exception e) {
			mess = new Message(e.getMessage(), "true");
		}

		return mess;
	}

    /**
     * 用户退出
     *
     * @param session
     * @throws IOException
     */
    @RequestMapping(value = "exit")
    public String exit(HttpSession session) throws IOException {
        // 注销session, 返回到首页
        if(session!=null){
            session.invalidate();
        }

        return "/User/index";
    }

    /**
     * 加入收藏
     */
    @ResponseBody
    @RequestMapping(value = "/addCollect")
    public String addCollect(HttpSession session, HttpServletRequest request) {
        user user = (user) session.getAttribute("user");
        String hid=request.getParameter("hid");
        if(user!=null){
            collect cl = new collect();
            cl.setUid(user.getUid());
            cl.setHid(hid);
            if(userService.isHaveHouseByUid(cl)==null||!userService.isHaveHouseByUid(cl).equals(hid)){
                userService.addCollect(cl);
                return "true";
            }

            return "false";
        }

        return "noLogin";

    }

    @RequestMapping(value = "queryCollect")
    public PageBean<house> queryCollect(String uid, HttpServletRequest request) {

        // 获取当前页码

        // 获得请求url
        PageBean<house> pb = userService.queryCollect(uid);
        return pb;
    }

    @ResponseBody
    @RequestMapping("/checkOldPwd")
    public boolean checkOldPwd(HttpServletRequest request, HttpSession session){
        String oldPwd=request.getParameter("oldpwd");
        user user= (user) session.getAttribute("user");
        if(oldPwd.equals(user.getUpwd())){
            return true;
        }
        return false;
    }
}
