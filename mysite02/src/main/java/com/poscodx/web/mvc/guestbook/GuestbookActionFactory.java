package com.poscodx.web.mvc.guestbook;

import com.poscodx.mysite02.dao.GuestbookDao;
import com.poscodx.mysite02.vo.GuestbookVo;
import com.poscodx.web.mvc.Action;
import com.poscodx.web.mvc.ActionFactory;
import com.poscodx.web.mvc.user.JoinFormAction;

import java.util.List;

public class GuestbookActionFactory implements ActionFactory {
    @Override
    public Action getAction(String actionName) {
        Action action = null;

        if ("insert".equals(actionName)) {
            action = new InsertAction();
        } else if ("delete".equals(actionName)) {
            action = new DeleteAction();

        } else if ("deleteform".equals(actionName)) {
            action = new DeleteFormAction();

        } else {

            action = new ListAction();

        }

        return action;
    }
}
