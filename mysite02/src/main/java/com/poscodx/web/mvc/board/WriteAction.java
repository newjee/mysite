package com.poscodx.web.mvc.board;

import com.poscodx.mysite02.dao.BoardDao;
import com.poscodx.mysite02.vo.BoardVo;
import com.poscodx.mysite02.vo.UserVo;
import com.poscodx.web.mvc.Action;
import com.poscodx.web.utils.WebUtil;

import javax.naming.Name;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class WriteAction implements Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String gNoParam = request.getParameter("gNo");
        String oNoParam = request.getParameter("oNo");
        String depthParam = request.getParameter("depth");
        System.out.println(gNoParam);

        if (gNoParam != null && !gNoParam.isEmpty()) {
            request.setAttribute("gNo", Long.parseLong(gNoParam));
        }

        if (oNoParam != null && !oNoParam.isEmpty()) {
            request.setAttribute("oNo", Long.parseLong(oNoParam));
        }

        if (depthParam != null && !depthParam.isEmpty()) {
            request.setAttribute("depth", Long.parseLong(depthParam));
        }

        WebUtil.forward("board/write", request, response);


    }
}
