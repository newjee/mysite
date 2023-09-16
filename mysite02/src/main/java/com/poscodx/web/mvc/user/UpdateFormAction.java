package com.poscodx.web.mvc.user;

import com.poscodx.mysite02.dao.UserDao;
import com.poscodx.mysite02.vo.UserVo;
import com.poscodx.web.mvc.Action;
import com.poscodx.web.utils.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
public class UpdateFormAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Access Control(보안, 인증체크)
        HttpSession session = request.getSession();
        UserVo authUser = (UserVo)session.getAttribute("authUser");
        if(authUser == null) {
            response.sendRedirect(request.getContextPath());
            return;
        }
        //////////////////////////////////////////////////////

        Long no = authUser.getNo();
        String name = authUser.getName();
        UserVo userVo = new UserDao().findAll(no, name);

        request.setAttribute("userVo", userVo);
        WebUtil.forward("user/updateform", request, response);
    }

}