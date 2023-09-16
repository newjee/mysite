package com.poscodx.web.mvc.board;

import com.poscodx.mysite02.dao.BoardDao;
import com.poscodx.mysite02.vo.BoardVo;
import com.poscodx.web.mvc.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class modifyformAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        BoardVo vo = new BoardDao().findByNo(Long.valueOf(request.getParameter("no")));


        if( request.getParameter("title") !=null){
            vo.setTitle(request.getParameter("title"));
        }
        if (request.getParameter("cotents") != null) {
            vo.setContents(request.getParameter("contents"));
        }

        new BoardDao().modifyUpdate(vo);

        response.sendRedirect(request.getContextPath() + "/board");


    }
}
