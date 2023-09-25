package com.poscodx.mysite.interceptor;

import com.poscodx.mysite.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SiteIntercepotor implements HandlerInterceptor {

    @Autowired
    private SiteService siteService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("SiteInterceptor.preHandler() called");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
