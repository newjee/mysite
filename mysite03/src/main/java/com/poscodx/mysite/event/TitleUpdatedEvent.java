package com.poscodx.mysite.event;

import org.springframework.context.ApplicationEvent;

public class TitleUpdatedEvent extends ApplicationEvent {

    private String newTitle;

    public TitleUpdatedEvent(Object source, String newTitle) {
        super(source);
        this.newTitle = newTitle;
    }

    public String getNewTitle() {
        return newTitle;
    }
}
