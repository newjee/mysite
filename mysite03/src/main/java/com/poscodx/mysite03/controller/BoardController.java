package com.poscodx.mysite03.controller;

import com.poscodx.mysite03.repository.BoardRepository;
import com.poscodx.mysite03.service.BoardService;
import com.poscodx.mysite03.vo.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;


    @RequestMapping("")
    public String main(Model model) {
//        List<BoardVo> list  = BoardService.getContentsList();
        return "/board/list";
    }

//    @RequestMapping("")


}
