package com.poscodx.mysite.controller;

import com.poscodx.mysite.security.Auth;
import com.poscodx.mysite.service.SiteService;
import com.poscodx.mysite.vo.SiteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;


@Auth(Role = "ADMIN")

//role이 admin이 아니면
@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    private SiteService siteService;

    @RequestMapping("")
    public String main(Model model) {

        SiteVo siteVo = siteService.getSite();
        model.addAttribute("siteVo", siteVo);

        return "admin/main";
    }
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String update(SiteVo siteVo) {
        System.out.println(siteVo + "<<<<<<sitevo");
        siteService.UpdateSite(siteVo);
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
