package com.poscodx.mysite.controller;

import com.poscodx.mysite.event.TitleUpdatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {

    @Autowired
    private ApplicationEventPublisher eventPublisher; // 이벤트 발행자 주입

    @GetMapping("/myPage")
    public String myPage(Model model) {
        // 모델에 데이터를 추가
        String message = "안녕하세요!";
        model.addAttribute("greeting", message);

        // 타이틀 변경 이벤트 발생 및 데이터 전달
        String newTitle = "새로운 타이틀"; // 새로운 타이틀 값을 설정
        eventPublisher.publishEvent(new TitleUpdatedEvent(this, newTitle));

        return "header"; // myPage.jsp로 포워딩
    }
}
