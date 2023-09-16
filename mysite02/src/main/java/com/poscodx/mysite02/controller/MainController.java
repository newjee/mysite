package com.poscodx.mysite02.controller;

import com.poscodx.web.mvc.Action;
import com.poscodx.web.mvc.main.MainActionFactory;
import com.poscodx.web.mvc.user.UserActionFactory;

import java.io.*;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "MainController", urlPatterns = {"/main"}, initParams = {
        @WebInitParam(name = "config", value = "/WEB-INF/servlet-context.xml")
})
public class MainController extends HttpServlet {

    @Override
    public void init() throws ServletException {
        String configPath = getServletConfig().getInitParameter("config");
        System.out.println(configPath);

        super.init();
    }

    private String message;

//    public void init() {
//        message = "Hello World!";
//    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //필터로 빼기?

        String actionName = request.getParameter("a");
        //여기에 userAction을 쓰는게 문제..?
        //servlet 파라미터로 혹은 servlet init으로
        Action action = new MainActionFactory()
                .getAction(actionName);
        action.execute(request, response);


//        request.getRequestDispatcher("/WEB-INF/views/main/index.jsp")
//                .forward(request, response);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}