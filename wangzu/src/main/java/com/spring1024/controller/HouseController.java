package com.spring1024.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.spring1024.bean.*;
import com.spring1024.service.houseService;
import com.spring1024.service.landlordService;
import com.spring1024.util.PageBean;
import com.spring1024.util.PageUtil;
import com.spring1024.util.UuidBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

/**
 * 房屋信息控制器
 *
 * @author xzc
 */

@Controller
public class HouseController {

    private static final Logger logger = LoggerFactory.getLogger(HouseController.class);

    @Autowired
    private houseService houseService;
    @Autowired
    private landlordService landlordService;

    private String hid;
    /**
     * 增加房源信息
     *
     * @param house
     * @param picFile
     * @param session
     * @param model
     * @return
     * @throws IOException
     * @throws IllegalStateException
     */
    @RequestMapping(value = "/admin/addHouse")
    public String addHouse(HttpServletRequest request, house house, MultipartFile[] picFile,
                           HttpSession session, RedirectAttributesModelMap model) throws IllegalStateException, IOException {
        if(house.getHid()!=hid){
            house.setHid(hid);
        }
        house.setHmodel(house.getHmodel()+"室");
        //房源状态默认为未出租
        house.setHstate(0);
        if(house.getHtype()==2){
            house.setHprice(house.getHprice()*10000);
        }
        if(session.getAttribute("admin") !=null){
            admin admin= (admin) session.getAttribute("admin");
            house.setHbelong(admin.getAid());
        }else if(session.getAttribute("landlord")!=null){
            landlord landlord=(landlord)session.getAttribute("landlord");
            house.setHbelong(landlordService.findLandlordByName(landlord.getLname()).getLid());
        }
        // 将图片保存到数据库中
        houseService.addHouse(house);
        return "redirect:/admin/html/houseTable";
    }

    //房屋展示图片上传
    @ResponseBody
    @RequestMapping("/mainImg_upload")
    public Map houseMainImg_upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        String prefix = "";
        //保存上传
        OutputStream out = null;
        InputStream fileInput = null;
        try {
            if (file != null) {
                String originalName = file.getOriginalFilename();
                prefix = originalName.substring(originalName.lastIndexOf(".") + 1);
                String uuid = UuidBean.GetUuid();
                String filepath = "E:\\wangzu\\src\\main\\resources\\static\\User\\images\\house\\main\\" + uuid + "." + prefix;
                File files = new File(filepath);
                //打印查看上传路径
                // System.out.println(filepath);
                if (!files.getParentFile().exists()) {
                    files.getParentFile().mkdirs();
                }
                file.transferTo(files);
                Map<String, Object> map2 = new HashMap<>();
                Map<String, Object> map = new HashMap<>();
                map.put("code", 0);
                map.put("msg", "");
                map.put("data", map2);
                map2.put("src", "/images/house/main" + "/" + uuid + "." + prefix);
                return map;
            }

        } catch (Exception e) {
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (fileInput != null) {
                    fileInput.close();
                }
            } catch (IOException e) {
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("msg", "");
        return map;
    }

    //房屋其他图片上传
    @ResponseBody
    @RequestMapping("/aboutImg_upload")
    public Map houseAboutImg_upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        String prefix = "";
        hid=request.getParameter("hid");
        System.out.println(hid);
        img img=new img();
        img.setHid(hid);
        //保存上传
        OutputStream out = null;
        InputStream fileInput = null;
        try {
            if (file != null) {
                String originalName = file.getOriginalFilename();
                prefix = originalName.substring(originalName.lastIndexOf(".") + 1);
                String uuid = UuidBean.GetUuid();
                img.setIid(uuid);
                String url="/images/house/about/"+uuid + "." + prefix;
                img.setIimg(url);
                    houseService.addImgs(img);
                String filepath = "E:\\wangzu\\src\\main\\resources\\static\\User\\images\\house\\about\\" + uuid + "." + prefix;
                File files = new File(filepath);
                //打印查看上传路径
//                System.out.println(filepath);
                if (!files.getParentFile().exists()) {
                    files.getParentFile().mkdirs();
                }
                file.transferTo(files);
                Map<String, Object> map2 = new HashMap<>();
                Map<String, Object> map = new HashMap<>();
                map.put("code", 0);
                map.put("msg", "");
                map.put("data", map2);
                map2.put("src", "/images/house/about/"  + uuid + "." + prefix);
                return map;
            }

        } catch (Exception e) {
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (fileInput != null) {
                    fileInput.close();
                }
            } catch (IOException e) {
            }
        }
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("msg", "");
        return map;
    }

    /**
     * 根据条件查找房源
     * 进行分页
     *
     * @param vo
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/queryByCondition")
    public PageBean<house> queryByCondition(QueryVo vo, String hprice,
                                            HttpServletRequest request) {
        // 获取当前页码
        int pc = PageUtil.getPc(request);
        // 获得请求url
        String url = PageUtil.getUrl(request);
        //转换居住方式
            if (vo.getHtype()==3) {
                vo.setHtype(3);
            } else if (vo.getHtype()==1) {
                vo.setHtype(1);
            } else if(vo.getHtype()==2){
                vo.setHtype(2);
            }
        //转换价钱
        if (hprice != null) {
            if (hprice.contains("以上")) {
                String price = hprice.substring(0, hprice.indexOf("以上"));
                vo.setLprice(Double.parseDouble(price));
            } else {
                vo.setLprice(Double.parseDouble(hprice.split("-")[0]));
                vo.setHpric(Double.parseDouble(hprice.split("-")[1]));
            }
        }

        vo.setMethod(1);
        //查询数据
        PageBean<house> pb = houseService.queryHousesByCondition(vo, pc);
        // 设置当前页
        pb.setPc(pc);
        // 设置请求路径
        pb.setUrl(url);

        return pb;
    }

    /**
     * 跳转到条件查询页面
     *
     * @return
     */
    @RequestMapping(value = "/housesPage")
    public ModelAndView skipHousesPage(String searchVal) {
        ModelAndView md = new ModelAndView();

        //默认请求路径
        String url = "/queryByCondition?query=1";

        if (searchVal != null && !StringUtils.isEmpty(searchVal)) {
            url += "&searchVal=" + searchVal;
        }

        md.addObject("url", url);
        md.setViewName("/User/services");
        return md;
    }

    /**
     * 查看房子详细
     *
     * @param hid
     * @return
     */
    @RequestMapping(value = "/houseDetail")
    public ModelAndView skipHouseDetailPage(String hid) {
        ModelAndView md = new ModelAndView();
        //先查询该房子的所有信息
        house h = houseService.queryHouseByHid(hid);
        h.setHclick(h.getHclick() + 1);
        houseService.updateHouseByHid(h);
        if (h.getHbelong()!= null) {
            landlord landlord = landlordService.queryByLid(h.getHbelong());
            md.addObject("landlord", landlord);
        } else {
            landlord landlord = new landlord("网租包租婆", "15216026804", "wz");
            md.addObject("landlord", landlord);
        }
        List<house> hl = houseService.queryLikeHouses(h);
        //带出该房子所有的图片
        List<img> imgs = houseService.getAllImgsByHid(hid);
        md.addObject("hl", hl);
        md.addObject("h", h);
        md.addObject("imgs", imgs);
        md.setViewName("/User/detail");
        return md;
    }
//	  @RequestMapping("/webupload_pic")
//	  @ResponseBody
//	  public MessageInfo webuploadPic(HttpServletRequest request) throws IOException {
//	   MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//	   Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
//	   List<String> file_url_list = List.newArrayList();
//	   for (MultipartFile file:fileMap.values()) {
//	    file_url_list.add("/pictures/"+FileUtil.uploadFile(file, pictures_url));
//	   }
//	   return ResultGenerator.genSuccessResult(file_url_list);
//	  }

    /**
     * 删除指定的房源 已出租的房源不能删除
     *
     * @return
     */
//	@SystemControllerAnnotation(value = "删除指定的房源信息 ")
    @RequestMapping(value = "/admin/deleteHome")
    public String delHouseByHid(String hid, RedirectAttributesModelMap model, HttpSession session) {

        String msg = "";

        admin admin = (admin) session.getAttribute("admin");

//		// 已出租的房源不能删除
//		if (house == null || "1".equals(house.getHstate())) {
//			msg = "已出租的房源[" + house.getHid() + "]不能删除";
//		} else {
        try {
            // 删除房源信息
            houseService.delHouseByHid(hid);
//				// 删除房源对应的图片
//				File f = new File("E:\\html\\wz" + house.getHimg());
//				if (f != null) {
//					f.delete();
//				}
//				f = null;
//
//				// 查找出该房源对应的其它图片
//				List<Imgs> imgs = houseService.getAllImgsByHid(house.getHid());
//				if (imgs != null && imgs.size() > 0) {
//					// 删除数据库中的记录
//					houseService.delAllImgsByHid(house.getHid());
//					// 删除所有图片
//					for (Imgs img : imgs) {
//						f = new File("D:\\" + img.getIimg());
//						if (f != null) {
//							f.delete();
//						}
//					}
//				}

            msg = "删除房源信息[" + hid + "]成功";
        } catch (Exception e) {
            msg = e.getMessage();
        }

        model.addFlashAttribute("msg", msg);
        logger.info("{}" + msg + "!", admin.getAname());
        return "redirect:/admin/admin_home";
    }

    /**
     * 更新房屋信息
     */
////	@SystemControllerAnnotation(value = "更新指定的房源信息 ")
//    @RequestMapping(value = "/admin/update")
//    public ModelAndView updateHouse(house house, HttpServletRequest request, HttpSession session, QueryVo vo) {
//        houseService.updateHouseByHid(house);
//        ModelAndView md = new ModelAndView();
//
//        // 获取当前页码
//        int pc = PageUtil.getPc(request);
//        // 获得请求url
//        String url = PageUtil.getUrl(request);
//        if (session.getAttribute("Landlord") != null) {
//            landlord landlord = (landlord) session.getAttribute("Landlord");
//            // 查询数据
//            PageBean<house> pb = landlordService.queryHousesByLid(landlord, pc);
//            // 设置当前页
//            pb.setPc(pc);
//            // 设置请求路径
//            pb.setUrl(url);
//            md.addObject("pb", pb);
//            md.setViewName("/Admin/home");
//        }
//        if (session.getAttribute("admin") != null) {
//            //设置为后台访问
//            vo.setMethod(0);
//            // 查询数据
//            PageBean<house> pb = houseService.queryHousesByCondition(vo, pc);
//            // 设置当前页
//            pb.setPc(pc);
//            // 设置请求路径
//            pb.setUrl(url);
//            md.addObject("pb", pb);
//            md.setViewName("/Admin/home");
//        }
//        return md;
//    }
}
