package com.articanne.booker.controller;

import com.articanne.booker.model.dto.UserDto;
import com.articanne.booker.service.CustomUserDetails;
import com.articanne.booker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public ModelAndView admin(ModelAndView mv) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) auth.getPrincipal();
        UserDto userDto = userService.findByUsername(customUserDetails.getUsername());

        mv.addObject("loggedInUser", userDto);
        mv.setViewName("admin");
        return mv;
    }
}
