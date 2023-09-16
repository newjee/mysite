package com.poscodx.web.mvc.board;

import com.poscodx.mysite02.dao.BoardDao;
import com.poscodx.mysite02.vo.BoardVo;
import com.poscodx.mysite02.vo.UserVo;
import com.poscodx.web.mvc.Action;
import com.poscodx.web.utils.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class WriteFormAction implements Action {


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Access Control(보안, 인증체크)
        HttpSession session = request.getSession();
        UserVo authUser = (UserVo) session.getAttribute("authUser");
        if (authUser == null) {
            response.sendRedirect(request.getContextPath());
            return;
        }
        ////////////////////////////////////////////////////////////////////

        BoardVo vo = new BoardVo();

        vo.setTitle(request.getParameter("title"));
        vo.setContents(request.getParameter("contents"));
        vo.setHit(0L);
        System.out.println("+++++"+request.getParameter("oNo"));
        System.out.println("+++++"+request.getParameter("depth"));

        if (request.getParameter("gNo") != null) {
            vo.setgNo(Long.valueOf(request.getParameter("gNo")));
            vo.setoNo(Long.valueOf(request.getParameter("oNo")));
            vo.setDepth(Long.valueOf(request.getParameter("depth")));

        } else {

            vo.setMaxGNo(new BoardDao().getMaxGNo());
            vo.setgNo(vo.getMaxGNo()+1);
            vo.setoNo(1L);
            vo.setDepth(1L);
        }


        System.out.println("++++++"+vo);
        System.out.println("+++++"+request.getParameter("oNo"));
        System.out.println("+++++"+request.getParameter("depth"));
        System.out.println(request.getParameter("oNo"));
        vo.setUserNo(authUser.getNo());

        new BoardDao().update(vo);

        new BoardDao().insert(vo);



        response.sendRedirect(request.getContextPath() + "/board");



    }
}
