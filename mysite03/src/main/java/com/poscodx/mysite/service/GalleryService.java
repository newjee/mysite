package com.poscodx.mysite.service;

import com.poscodx.mysite.repository.GalleryRepository;
import com.poscodx.mysite.security.Auth;
import com.poscodx.mysite.vo.GalleryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GalleryService {

    @Autowired
    private GalleryRepository galleryRepository;

    public List<GalleryVo> getImages() {

        return null;
    }


    @Auth
    public void removeImage(Long no) {

    }

    public void addImage(GalleryVo vo) {

    }
}
