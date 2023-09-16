package com.poscodx.mysite03.service;

import com.poscodx.mysite03.repository.GuestBookRepository;
import com.poscodx.mysite03.vo.GuestBookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestBookService {

    @Autowired
    private GuestBookRepository guestBookRepository;


    public List<GuestBookVo> getContentsList() {
        return guestBookRepository.findAll();
    }

    public Boolean deleteContents(Long no, String password) {
        return guestBookRepository.deleteByNoAndPassword(no, password);
    }

    public Boolean addContents(GuestBookVo vo) {
        return guestBookRepository.insert(vo);
    }
}
