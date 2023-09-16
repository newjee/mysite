package com.poscodx.web.mvc.board;

import com.poscodx.mysite02.dao.BoardDao;
import com.poscodx.mysite02.dao.GuestbookDao;
import com.poscodx.mysite02.vo.BoardVo;
import com.poscodx.mysite02.vo.GuestbookVo;
import com.poscodx.web.mvc.Action;
import com.poscodx.web.utils.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

public class BoardListAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //검색 처리
        String kwd = "";
        if (request.getParameter("kwd") != null) {
            kwd = request.getParameter("kwd"); }
        kwd = "%" + kwd + "%";

        //페이징 처리
        Long page = 1L;
        Long pageLimit = 5L;
        if (request.getParameter("page") != null) {
            page = Long.valueOf(request.getParameter("page"));}
        BoardVo vo = new BoardDao().pageCnt(kwd);

        Long pageCnt = vo.getPageCnt();
        Long start = (page-1) / pageLimit * pageLimit +1 ;
        Long total = (pageCnt% 5 != 0) ? (Long)(pageCnt / 5 )+ 1 : (Long) (pageCnt / 5);
        Long end = start + pageLimit -1;
        if (end > total){ end = total;}

//        System.out.println("end"+end);
        request.setAttribute("total", total);
        request.setAttribute("start", start);
        request.setAttribute("end", end);
        request.setAttribute("selectedPage", page);
        request.setAttribute("pageCnt", pageCnt);

//        System.out.println(page);
        List<BoardVo> list = new BoardDao().findAll(page,kwd);
        request.setAttribute("list", list);


        WebUtil.forward("board/list", request, response);

    }
}
