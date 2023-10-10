package com.poscodx.mysite.controller;

import com.poscodx.mysite.security.Auth;
import com.poscodx.mysite.service.FileuploadService;
import com.poscodx.mysite.service.SiteService;
import com.poscodx.mysite.vo.SiteVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.util.Map;


@Auth(Role = "ADMIN")

//role이 admin이 아니면
@RequestMapping("/admin")
@Controller
public class AdminController {

    // applicationContext 활용
    @Autowired
    private ApplicationContext applicationContext;

    // interceptor 주입
    @Autowired
    private ServletContext servletContext;

    @Autowired
    private SiteService siteService;

    @Autowired
    private FileuploadServiceploadService fileuploadService;

    @RequestMapping("")
    public String main(Model model) {

        SiteVo siteVo = siteService.getSite();
        model.addAttribute("siteVo", siteVo);

        return "admin/main";
    }
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String update(
            MultipartFile file,
            SiteVo siteVo) {


        String profile = FileuploadService.restore(file);
        if(profile != null) {
            siteVo.setProfile(profile);
        }

        SiteVo site = applicationContext.getBean(SiteVo.class);

        System.out.println("$$$$$$controller"+ siteVo + "");
        siteService.updateSite(siteVo);
        servletContext.setAttribute("siteVo",siteVo);

//        site.setTitle(siteVo.getTitle());
//        site.setWelcome(siteVo.getWelcome());
//        site.setProfile(siteVo.getProfile());
//        site.setDescription(siteVo.getDescription());
        BeanUtils.copyProperties(siteVo, site);

        return "redirect:/admin";
    }



    @RequestMapping("/guestbook")
    public String guestbook() {
        return "admin/guestbook";
    }

    @RequestMapping("/board")
    public String board() {
        return "admin/board";
    }

    @RequestMapping("/user")
    public String user() {
        return "admin/user";
    }
}