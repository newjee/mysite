package com.poscodx.web.mvc.guestbook;

import com.poscodx.mysite02.dao.GuestbookDao;
import com.poscodx.web.mvc.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String no = request.getParameter("no");
        String password = request.getParameter("password");

        new GuestbookDao().deleteByNoAndPassword(Long.parseLong(no), password);

        response.sendRedirect(request.getContextPath() + "/guestbook");
    }
}
