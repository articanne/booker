package com.articanne.booker.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping({"", "/", "/home"})
    public ModelAndView home(ModelAndView mv) {
        mv.setViewName("home");
        mv.addObject("appName", appName);
        return mv;
    }
}