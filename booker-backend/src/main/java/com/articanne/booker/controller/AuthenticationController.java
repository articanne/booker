package com.articanne.booker.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AuthenticationController {

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/login")
    public ModelAndView login(ModelAndView mv) {
        mv.setViewName("login");
        mv.addObject("appName", appName);
        return mv;
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    @GetMapping("/access_denied")
    public ModelAndView accessDenied() {
        ModelAndView mv = new ModelAndView("access_denied");
        mv.addObject("title", "Access denied");
        mv.addObject("message", "Access denied");
        mv.addObject("details", "You do not have permission to access this page.");
        mv.addObject("image", "https://giphy.com/embed/auCFmBjrOZ9HaJM9WH");
        return mv;
    }

}
