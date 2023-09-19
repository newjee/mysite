package com.poscodx.mysite03.service;

import com.poscodx.mysite03.repository.BoardRepository;
import com.poscodx.mysite03.repository.UserRepository;
import com.poscodx.mysite03.vo.BoardVo;
import com.poscodx.mysite03.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    // @Autowired
    // private MailSender mailSender;

    @Autowired
    private BoardRepository boardRepository;

    public void getContentsList() {


//        return boardRepository.findAll();
    }

}