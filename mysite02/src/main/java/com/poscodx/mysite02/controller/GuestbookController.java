package com.poscodx.mysite02.controller;

import com.poscodx.mysite02.dao.GuestbookDao;
import com.poscodx.mysite02.vo.GuestbookVo;
import com.poscodx.web.mvc.Action;
import com.poscodx.web.mvc.guestbook.GuestbookActionFactory;
import com.poscodx.web.mvc.user.UserActionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/guestbook")

public class GuestbookController extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        String actionName = request.getParameter("a");
        //여기에 userAction을 쓰는게 문제..?
        //servlet 파라미터로 혹은 servlet init으로
        Action action = new GuestbookActionFactory()
                .getAction(actionName);

        action.execute(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}