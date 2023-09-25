package com.poscodx.mysite.controller;

import com.poscodx.mysite.security.Auth;
import com.poscodx.mysite.service.FileuploadService;
import com.poscodx.mysite.service.SiteService;
import com.poscodx.mysite.vo.SiteVo;
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


    @Autowired
    private ApplicationContext applicationContext;

    // interceptor 주입
    @Autowired
    private ServletContext servletContext;

    @Autowired
    private SiteService siteService;

    @Autowired
    private FileuploadService fileuploadService;

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


        String url = FileuploadService.restore(file);
        if(url != null) {
            siteVo.setProfile(url);
        }


        System.out.println("$$$$$$controller"+ siteVo + "");
        siteService.updateSite(siteVo);
        servletContext.setAttribute("siteVo",siteVo);

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