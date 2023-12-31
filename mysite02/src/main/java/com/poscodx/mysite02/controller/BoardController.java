package com.poscodx.mysite02.controller;

import com.poscodx.web.mvc.Action;
import com.poscodx.web.mvc.board.BoardActionFactory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public BoardController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setCharacterEncoding("utf-8");
        String actionName = request.getParameter("a");
        Action action = new BoardActionFactory()
                .getAction(actionName);

        action.execute(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}