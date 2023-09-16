package com.poscodx.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.*;

public class ContextLoadListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        sc.getInitParameter("contextConfigLocation");
        System.out.println("application starts.......");
    }


    public void contextDestroyed(ServletContextEvent sce) {
    }
}