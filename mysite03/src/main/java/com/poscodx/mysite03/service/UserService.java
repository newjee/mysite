package com.poscodx.mysite03.service;

import com.poscodx.mysite03.repository.GuestBookRepository;
import com.poscodx.mysite03.repository.UserRepository;
import com.poscodx.mysite03.vo.GuestBookVo;
import com.poscodx.mysite03.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private MailSender mailSender;

    public void join(UserVo vo) {
// mailSender.send(vo.getEmail(),"","");
        userRepository.insert(vo);
    }

    public UserVo getUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);

    }
}
