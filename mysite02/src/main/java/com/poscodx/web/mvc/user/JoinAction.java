package com.poscodx.web.mvc.user;

import com.poscodx.mysite02.dao.UserDao;
import com.poscodx.mysite02.vo.UserVo;
import com.poscodx.web.mvc.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.SortedMap;

public class JoinAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");

        UserVo userVo = new UserVo();
        userVo.setName(name);
        userVo.setEmail(email);
        userVo.setPassword(password);
        userVo.setGender(gender);
        System.out.println(userVo);
        new UserDao().insert(userVo);

        //req3
        response.sendRedirect(request.getContextPath()+"/user?a=joinsuccess");

    }
}
