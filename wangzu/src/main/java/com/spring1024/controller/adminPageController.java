package com.spring1024.controller;

import com.spring1024.bean.landlord;
import com.spring1024.service.houseService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class adminPageController {
    @Autowired
    private houseService houseService;

    @RequiresRoles("admin")
    @RequiresPermissions("add")
    @RequestMapping("/html/index")
    public String adminIndex(){
        return "/Admin/html/index";
    }

    @RequestMapping("/login")
    public String adminLogin(){
        return "/Admin/login";
    }

    @RequestMapping("/html/multi_image_upload")
    public String adminMultiImageUpload() {
        return "Admin/html/multi_image_upload";
    }

    @RequestMapping("/html/rich_editor")
    public String adminRichEditor() {
        return "Admin/html/rich_editor";
    }

    @RequiresRoles("admin")
    @RequiresPermissions("add")
    @RequestMapping("/html/userTable")
    public String userTable() {
        return "Admin/html/userTable";
    }

    @RequiresRoles("admin")
    @RequiresPermissions("add")
    @RequestMapping("/html/houseTable")
    public String houseTable() {
        return "Admin/html/houseTable";
    }

    @RequiresRoles("admin")
    @RequiresPermissions("add")
    @RequestMapping("/html/landlordTable")
    public String landlordTable() {
        return "Admin/html/landlordTable";
    }

    @RequiresRoles("admin")
    @RequiresPermissions("add")
    @RequestMapping("/html/adminTable")
    public String adminTable() {
        return "Admin/html/adminTable";
    }

    @RequiresRoles("admin")
    @RequiresPermissions("add")
    @RequestMapping("/html/houseUpload")
    public String houseUpload() {
        return "Admin/html/houseUpload";
    }

    @RequiresRoles("admin")
    @RequiresPermissions("add")
    @RequestMapping(value = "/index")
    public ModelAndView skipAdminIndexPage(HttpSession session) {
        ModelAndView md = new ModelAndView();
        if (session.getAttribute("admin") != null) {
            int clNum = houseService.queryClick();
            int houseNum = houseService.queryCount();
            md.addObject("houseNum", houseNum);
            md.addObject("clNum", clNum);
        }
        if (session.getAttribute("Landlord") != null) {
            System.out.println(session.getAttribute("Landlord"));
            landlord landlord = (landlord) session.getAttribute("Landlord");
            int houseNum = houseService.queryCountByLid(landlord.getLid());
            int clNum = houseService.queryClickByLid(landlord.getLid());
            md.addObject("houseNum", houseNum);
            md.addObject("clNum", clNum);
        }
        md.setViewName("/Admin/index");
        return md;
    }
}
