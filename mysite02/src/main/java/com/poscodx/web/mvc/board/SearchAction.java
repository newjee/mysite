package com.poscodx.web.mvc.board;

import com.poscodx.mysite02.dao.UserDao;
import com.poscodx.mysite02.vo.BoardVo;
import com.poscodx.mysite02.vo.UserVo;
import com.poscodx.web.mvc.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SearchAction implements Action {


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String kwd = request.getParameter("kwd");

        BoardVo boardVo = new BoardVo();
        boardVo.setKwd(kwd);

//        response.sendRedirect(request.getContextPath()+"/board");


    }
}
