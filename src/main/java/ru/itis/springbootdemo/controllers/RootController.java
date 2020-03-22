package ru.itis.springbootdemo.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class RootController {
    @GetMapping
    public String getRootPage(Authentication authentication){
        if(authentication != null){
            return "redirect:/profile";
        } else{
            return "redirect:/signIn";
        }

    }
}
