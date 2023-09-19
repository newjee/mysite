package com.poscodx.mysite03.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

@ControllerAdvice
public class GloabalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handlerException(Model model, Exception e) {
        //1. Logging
        StringWriter errors = new StringWriter();
        e.printStackTrace(new PrintWriter(errors));
        System.out.println(errors.toString());


//        System.out.println(e);
        e.printStackTrace();

        //2. Apologize
        model.addAttribute("errors", errors.toString());
        return "error/exception";
    }
}
