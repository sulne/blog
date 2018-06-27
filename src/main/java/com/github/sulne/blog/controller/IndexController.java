package com.github.sulne.blog.controller;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@EnableScheduling
public class IndexController {
    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("/test");
    }
}
