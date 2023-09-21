package com.poscodx.mysite.service;

import com.poscodx.mysite.repository.SiteRepository;
import com.poscodx.mysite.vo.SiteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteService {

    @Autowired
    private SiteRepository siteRepository;

    public SiteVo getSite() {
        return siteRepository.find();
    }

    public void UpdateSite(SiteVo siteVo) {
        System.out.println(siteVo + "<<<<<service");
        siteRepository.update(siteVo);
    }

}
