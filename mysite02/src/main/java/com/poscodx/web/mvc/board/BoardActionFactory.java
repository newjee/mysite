package com.poscodx.web.mvc.board;

import com.poscodx.web.mvc.Action;
import com.poscodx.web.mvc.ActionFactory;
import com.poscodx.web.mvc.guestbook.DeleteAction;
import com.poscodx.web.mvc.guestbook.DeleteFormAction;
import com.poscodx.web.mvc.guestbook.InsertAction;
import com.poscodx.web.mvc.guestbook.ListAction;

public class BoardActionFactory implements ActionFactory {

    @Override
    public Action getAction(String actionName) {

        Action action = null;

        if ("modify".equals(actionName)) {
            action = new modifyAction();

        } else if ("modifyform".equals(actionName)) {
            action = new modifyformAction();

        } else if ("view".equals(actionName)) {
            action = new ViewAction();

        } else if ("write".equals(actionName)) {
            action = new WriteAction();

        } else if ("writeform".equals(actionName)) {
            action = new WriteFormAction();

        } else if ("delete".equals(actionName)) {
            action = new BoardDeleteAction();

        } else if ("search".equals(actionName)) {
            action = new SearchAction();

        } else {
            action = new BoardListAction();

        }

        return action;
    }
}
