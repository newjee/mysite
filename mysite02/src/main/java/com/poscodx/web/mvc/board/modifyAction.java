package com.poscodx.web.mvc.board;

import com.poscodx.web.mvc.Action;
import com.poscodx.web.utils.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class modifyAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String title = request.getParameter("title");
        String contents = request.getParameter("contents");
        Long no = Long.valueOf(request.getParameter("no"));
        request.setAttribute("title", title);
        request.setAttribute("contents", contents);
        request.setAttribute("no", no);

        WebUtil.forward("board/modify", request, response);

    }
}
