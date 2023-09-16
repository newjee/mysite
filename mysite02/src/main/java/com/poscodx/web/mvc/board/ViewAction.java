package com.poscodx.web.mvc.board;

import com.poscodx.mysite02.dao.BoardDao;
import com.poscodx.mysite02.vo.BoardVo;
import com.poscodx.web.mvc.Action;
import com.poscodx.web.utils.WebUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ViewAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        Long no = Long.valueOf(request.getParameter("no"));
        BoardVo boardVo = new BoardDao().findByNo(no);
        request.setAttribute("vo", boardVo);
        Long visitCount = boardVo.getHit();

        // 쿠키
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("visit-count".equals(cookie.getName())) {
                    visitCount = (long) Integer.parseInt(cookie.getValue());

                }
            }
        }
        // 조회수 +1 증가
        new BoardDao().increaseHit(no);

        //쿠키 굽기
        Cookie cookie = new Cookie("visit-count", String.valueOf(visitCount));
        cookie.setPath(request.getContextPath());
        cookie.setMaxAge(24 * 60 * 60); //1day
        response.addCookie(cookie);


        WebUtil.forward("board/view", request, response);

    }
}
