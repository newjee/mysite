package com.poscodx.mysite.event;

import com.poscodx.mysite.event.TitleUpdatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class TitleUpdatedEventListener {

    @EventListener
    public void handleTitleUpdatedEvent(TitleUpdatedEvent event) {
        String newTitle = event.getNewTitle();
        System.out.println("=========new"+newTitle);
    }
}
