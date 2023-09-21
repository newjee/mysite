package com.poscodx.mysite.controller;

import com.poscodx.mysite.security.Auth;
import com.poscodx.mysite.security.AuthUser;
import com.poscodx.mysite.service.UserService;
import com.poscodx.mysite.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String join() {
        return "user/join";
    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public String join(UserVo userVo) { //Bean Valuedation
        userService.join(userVo);
        return "redirect:/user/joinsuccess";
    }

    @RequestMapping(value = "/joinsuccess", method = RequestMethod.GET)
    public String joinsuccess() {
        return "user/joinsuccess";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "user/login";
    }


    @Auth
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@AuthUser UserVo authUser, UserVo userVo) {
//        UserVo authUser = (UserVo) session.getAttribute("authUser");
//        if (authUser == null) {
//            return "redirect:/user/login";
//        }
//        ////////////////////////////////////////////////////////////////////
        userVo.setNo(authUser.getNo());

        userService.update(userVo);

        authUser.setName(userVo.getName());

        return "redirect:/user/update";
    }

    @Auth //  횡단관심 분리로 접근제어는 가능하지만, 기술침투(httpsession)은 막지 못함!!
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(@AuthUser UserVo authUser, Model model) {
                        // HttpSession session--> @AuthUser : Argument Resolver
                        // 기술비침투 --> Argument Resolver 로

        //Access Control(접근 제어)
//        UserVo authUser = (UserVo) session.getAttribute("authUser");
//        if (authUser == null) {
//            return "redirect:/user/login";
//        }
//        ////////////////////////////////////////////////////////////////////

        UserVo userVo = userService.getUser(authUser.getNo());
        model.addAttribute("userVo", userVo);

        return "/user/update";
    }

//    @ExceptionHandler(Exception.class)
//    public String handlerException() {
//        return "error/excption";
//    }
}

