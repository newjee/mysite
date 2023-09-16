package com.poscodx.web.mvc.user;

import com.poscodx.web.mvc.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //session 없애는 작업
        HttpSession session = request.getSession();
        session.removeAttribute("authUser");
        //매니저한테 없애고 새로운 애 매핑
        session.invalidate();

        response.sendRedirect(request.getContextPath());
    }
}
