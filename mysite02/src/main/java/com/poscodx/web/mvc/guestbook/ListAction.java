package com.poscodx.web.mvc.guestbook;

import com.poscodx.mysite02.dao.GuestbookDao;
import com.poscodx.mysite02.vo.GuestbookVo;
import com.poscodx.web.mvc.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<GuestbookVo> list = new GuestbookDao().findAll();

        request.setAttribute("list", list);
        request.getRequestDispatcher("/WEB-INF/views/guestbook/index.jsp").forward(request, response);

    }
}
