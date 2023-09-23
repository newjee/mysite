package com.poscodx.mysite.service;

import com.poscodx.mysite.event.TitleUpdatedEvent;
import com.poscodx.mysite.repository.SiteRepository;
import com.poscodx.mysite.vo.SiteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class SiteService {

    @Autowired
    private SiteRepository siteRepository;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public SiteVo getSite() {
        return siteRepository.find();
    }

    public void updateSite(SiteVo siteVo) {
        System.out.println("$$$$$$service" + siteVo + "");
        siteRepository.update(siteVo);

        // 타이틀이 수정되었을 때 이벤트 발생
        String newTitle = siteVo.getTitle();
        eventPublisher.publishEvent(new TitleUpdatedEvent(this, newTitle));
    }
}
