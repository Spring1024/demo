package com.spring1024.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.spring1024.bean.landlord;
import com.spring1024.config.myToken;
import com.spring1024.service.houseService;
import com.spring1024.service.landlordService;
import com.spring1024.util.UuidBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Enumeration;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * @author xzc
 *
 */
@Controller
@RequestMapping(value="/landlord")
public class LandlordController {
//	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private houseService houseService;
	@Autowired
	private landlordService landlordService;
	/**
	 *
	 * 房东登录
	 * @param
	 * @param session
	 * @return
	 */
	@RequestMapping("/forLogin")
	public String login(landlord landlord, HttpSession session, HttpServletRequest request) {
	    if(session.getAttribute("role")!=null){
            Enumeration em = request.getSession().getAttributeNames();
            while(em.hasMoreElements()){
                request.getSession().removeAttribute(em.nextElement().toString());
            }
        }
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new myToken(landlord.getLname(),landlord.getLpwd(),"landlord"));
            int houseCount = houseService.queryCountByLid(landlordService.findLandlordByName(landlord.getLname()).getLid());
            int houseClickCount=houseService.queryClickByLid(landlordService.findLandlordByName(landlord.getLname()).getLid());
            session.setAttribute("landlord", landlord);
            session.setAttribute("role", "房东");
            session.setAttribute("houseCount", houseCount);
            session.setAttribute("houseClickCount",houseClickCount);
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
//
//
//	/**
//	 *
//	 * 房东退出登录
//	 * @param landlord
//	 * @param session
//	 * @return
//	 */
//	@RequestMapping("exit")
//	public String exit(landlord landlord,HttpSession session) {
//			session.invalidate();
//			logger.info("{} 退出系统。", landlord.getLname());
//			return "/admin/landlord_login";
//	}

    @RequestMapping("/addLandlord")
    public String addLandlord(landlord landlord){
	    if (landlord!=null) {
            landlord.setLid(UuidBean.GetUuid());
            System.out.println(landlord.getLid());
            landlord.setRid(5);
            landlordService.addLandlord(landlord);
            return "/Admin/html/landlordTable";
        }
	    return "/Admin/index";
    }
}
