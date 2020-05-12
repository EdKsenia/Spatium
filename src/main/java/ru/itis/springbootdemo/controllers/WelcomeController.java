package ru.itis.springbootdemo.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/welcome")
    public String getWelcomePage(Model model, Authentication authentication) {
        boolean isAut = false;
        if(authentication!=null){
            isAut = true;
        }
        model.addAttribute("aut", isAut);
        return "welcome";
    }
}
