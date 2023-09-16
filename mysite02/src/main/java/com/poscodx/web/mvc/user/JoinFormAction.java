package com.poscodx.web.mvc.user;

import com.poscodx.web.mvc.Action;
import com.poscodx.web.utils.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JoinFormAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        request.getRequestDispatcher("/WEB-INF/views/user/joinform.jsp")
//                .forward(request,response);

        WebUtil.forward("user/joinform", request, response);

    }
}
