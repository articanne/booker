package com.articanne.booker.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorHandlerController implements ErrorController {

    @RequestMapping("/error")
    public ModelAndView handleError(ModelAndView mv) {
        mv.setViewName("error");
        mv.addObject("title", "Internal Error");
        mv.addObject("message", "Internal Error");
        mv.addObject("details", "Sorry, something went wrong on our end.");
        mv.addObject("image", "https://giphy.com/embed/H7wajFPnZGdRWaQeu0");
        return mv;
    }
}
