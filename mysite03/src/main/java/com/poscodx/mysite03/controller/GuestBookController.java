package com.poscodx.mysite03.controller;

import com.poscodx.mysite03.service.GuestbookService;
import com.poscodx.mysite03.vo.GuestbookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/guestbook")
public class GuestBookController {

    @Autowired
    private GuestbookService guestbookService;

    @RequestMapping("")
    public String main(Model model) {
        List<GuestbookVo> list = guestbookService.getContentsList();
        model.addAttribute("list", list);
        return "guestbook/main";
    }

    @RequestMapping("/delete/{no}")
    public String delete(@PathVariable("no") Long no, Model model) {
        model.addAttribute("no", no);
        return "guestbook/delete";
    }

    @RequestMapping(value = "/delete/{no}", method = RequestMethod.POST)
    public String delete(@PathVariable("no") Long no, @RequestParam(value = "password", required = true, defaultValue = "") String password) {
        guestbookService.deleteContents(no, password);
        return "redirect:/guestbook";
    }

    @RequestMapping("add")
    public String add(GuestbookVo vo) {
        guestbookService.addContents(vo);
        return "redirect:/guestbook";
    }
}
