package com.poscodx.web.mvc.board;

import com.poscodx.mysite02.dao.BoardDao;
import com.poscodx.mysite02.dao.GuestbookDao;
import com.poscodx.web.mvc.Action;
import com.poscodx.web.utils.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BoardDeleteAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        String no = request.getParameter("no");

        new BoardDao().deleteByNoAndPassword(Long.parseLong(no));

        response.sendRedirect(request.getContextPath() + "/board");
//        WebUtil.forward("user/modify", request, response);


    }
}
