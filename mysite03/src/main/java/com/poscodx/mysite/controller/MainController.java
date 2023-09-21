package com.poscodx.mysite.controller;

import com.poscodx.mysite.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    private SiteService siteService;

    @RequestMapping("/")
    public String index() {
        return "main/index";
    }
}
