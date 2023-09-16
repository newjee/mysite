package com.poscodx.web.mvc.guestbook;

import com.poscodx.mysite02.dao.GuestbookDao;
import com.poscodx.mysite02.vo.GuestbookVo;
import com.poscodx.web.mvc.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InsertAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        //insertAction()
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String contents = request.getParameter("contents");

        GuestbookVo vo = new GuestbookVo();
        vo.setName(name);
        vo.setPassword(password);
        vo.setContents(contents);

        new GuestbookDao().insert(vo);
        response.sendRedirect(request.getContextPath() + "/guestbook");

    }
}
