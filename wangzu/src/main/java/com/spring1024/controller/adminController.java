package com.spring1024.controller;

import com.alibaba.fastjson.JSONObject;
import com.spring1024.bean.*;
import com.spring1024.config.myToken;
import com.spring1024.service.adminService;
import com.spring1024.service.houseService;
import com.spring1024.service.landlordService;
import com.spring1024.service.userService;
import com.spring1024.util.UuidBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class adminController {

    @Autowired
    private userService userService;
    @Autowired
    private houseService houseService;
    @Autowired
    private adminService adminService;
    @Autowired
    private landlordService landlordService;

    /**
     * 管理员登录
     *
     * @param admin
     * @param session
     * @return
     */
    @RequestMapping("/admin/forLogin")
    public String login(admin admin, HttpSession session,HttpServletRequest request) {
        if(session.getAttribute("role")!=null){
            //invalidated方法是使得session失效。
//            session.invalidate();
            Enumeration em = request.getSession().getAttributeNames();
            while(em.hasMoreElements()){
                request.getSession().removeAttribute(em.nextElement().toString());
            }
        }
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new myToken(admin.getAname(),admin.getApwd(),"admin"));
            int rid = adminService.findAdminByName(admin.getAname()).getRid();
            String role = adminService.fingAdminRole(rid).getRole();
            int houseCount = houseService.queryCount();
            int userCount = userService.queryUsers().size();
            int landlordCount = landlordService.queryLandlord().size();
            session.setAttribute("admin", admin);
            session.setAttribute("role", role);
            session.setAttribute("houseCount", houseCount);
            session.setAttribute("userCount", userCount);
            session.setAttribute("landlordCount", landlordCount);
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名不存在");
            return "/Admin/login";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("密码错误");
            return "/Admin/login";
        } catch (AuthorizationException e) {
            e.printStackTrace();
            System.out.println("无权限");
            return "/Admin/login";
        }
        return "redirect:/admin/index";
    }

    @ResponseBody
    @RequestMapping("/admin/deleteHouse")
    public String deleteHouse(HttpServletRequest request) {
        String str = request.getParameter("data");
        if(str.length()>32) {
            String[] hidList = str.split(",");
            for (String s : hidList
            ) {
                houseService.delHouseByHid(s);
                houseService.delAllImgsByHid(s);
                landlordService.deleteLandlordHouseID(s);
            }
        }else{
            houseService.delHouseByHid(str);
            houseService.delAllImgsByHid(str);
            landlordService.deleteLandlordHouseID(str);
        }
        return "true";
    }

    @ResponseBody
    @RequestMapping("/admin/userList")
    public String getUserList() {
        List<user> userList = userService.queryUsers();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("msg", "");
        jsonObject.put("count", userList.size());
        jsonObject.put("data", userList);
        return jsonObject.toJSONString();
    }

    @ResponseBody
    @RequestMapping("/admin/houseList")
    public String getHouseList(HttpServletRequest request,HttpSession session) {
        int limit = Integer.parseInt(request.getParameter("limit"));
        int page = Integer.parseInt(request.getParameter("page"));
        int pageNum=(page-1)*limit;
        String role= (String) session.getAttribute("role");
        JSONObject jsonObject = new JSONObject(true);
        if(role.endsWith("管理员")){
            List<house> houseList = houseService.queryAllHouses(pageNum,limit);
            jsonObject.put("code", 0);
            jsonObject.put("msg", "");
            jsonObject.put("count", houseService.queryCount());
            jsonObject.put("data", houseList);
        }
        if(role.endsWith("房东")){
            landlord landlord= (landlord) session.getAttribute("landlord");
            List<house> houseList=landlordService.queryHousesByLid(landlordService.findLandlordByName(landlord.getLname()).getLid(),pageNum,limit);
            jsonObject.put("code", 0);
            jsonObject.put("msg", "");
            jsonObject.put("count", houseList.size());
            jsonObject.put("data", houseList);
        }


        return jsonObject.toJSONString();
    }


    @ResponseBody
    @RequestMapping("/admin/landlordList")
    public String getLandlordList() {
        List<landlord> landlordList = landlordService.queryLandlord();
        System.out.println(landlordList.size());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("msg", "");
        jsonObject.put("count", landlordList.size());
        jsonObject.put("data", landlordList);
        return jsonObject.toJSONString();
    }


    @ResponseBody
    @RequestMapping("/admin/adminList")
    public String getAdminList() {
        List<admin> adminList = adminService.queryAllAdmin();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", 0);
        jsonObject.put("msg", "");
        jsonObject.put("count", adminList.size());
        jsonObject.put("data", adminList);
        return jsonObject.toJSONString();
    }

    @ResponseBody
    @RequestMapping("/admin/queryCount")
    public String test() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");//注意月份是MM
        Calendar rightNow = Calendar.getInstance();
        String queryDate = null;
        Map<String, Object> map = new HashMap<String, Object>();
        List<dataCount> houseCounts = new ArrayList<>();
        for (int i = 6; i >= 1; i--) {
            rightNow.add(Calendar.MONTH, -(i - 1));
            queryDate = simpleDateFormat.format(rightNow.getTime());
            dataCount houseCount = new dataCount(queryDate, houseService.getCountByDate(queryDate));
            houseCounts.add(houseCount);
            rightNow.add(Calendar.MONTH, +(i - 1));
        }
        List<dataCount> landlordCounts = new ArrayList<>();
        for (int j = 6; j >= 1; j--) {
            rightNow.add(Calendar.MONTH, -(j - 1));
            queryDate = simpleDateFormat.format(rightNow.getTime());
            dataCount landlordCount = new dataCount(queryDate, landlordService.getCountByDate(queryDate));
            landlordCounts.add(landlordCount);
            rightNow.add(Calendar.MONTH, +(j - 1));
        }
        List<dataCount> userCounts = new ArrayList<>();
        for (int k = 6; k >= 1; k--) {
            rightNow.add(Calendar.MONTH, -(k - 1));
            queryDate = simpleDateFormat.format(rightNow.getTime());
            dataCount userCount = new dataCount(queryDate, userService.getCountByDate(queryDate));
            userCounts.add(userCount);
            rightNow.add(Calendar.MONTH, +(k - 1));
        }
        map.put("houseCount", houseCounts);
        map.put("landlordCount", landlordCounts);
        map.put("userCount", userCounts);
        JSONObject jsonObject = new JSONObject(map);
        return jsonObject.toJSONString();
    }

    @ResponseBody
    @RequestMapping("/admin/deleteLandlord")
    public String deleteLandlord(HttpServletRequest request) {
        String str = request.getParameter("data");
        if(str.length()>32) {
            String[] lidList = str.split(",");
            for (String s : lidList
            ) {
                landlordService.deleteLandlordHByLid(s);
                houseService.delHouseByLid(s);
            }
        }else{
            landlordService.deleteLandlordHByLid(str);
            houseService.delHouseByLid(str);
        }
        return "true";
    }

    @ResponseBody
    @RequestMapping("/admin/deleteUser")
    public String deleteUser(HttpServletRequest request) {
        String str = request.getParameter("data");
        if(str.length()>32) {
            String[] uidList = str.split(",");
            for (String s : uidList
            ) {
                userService.deleteUserByUid(s);
            }
        }else{
            userService.deleteUserByUid(str);
        }
        return "true";
    }

    @RequestMapping("/admin/addAdmin")
    public String addAdmin(admin admin){
        if (admin!=null){
            admin.setAid(UuidBean.GetUuid());
            adminService.addAdmin(admin);
            return "/Admin/html/adminTable";
        }
        return "/Admin/index";
    }

}
