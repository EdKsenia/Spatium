package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.springbootdemo.dto.ChannelDto;
import ru.itis.springbootdemo.security.UserDetailsImpl;
import ru.itis.springbootdemo.service.CreateChannelService;

@Controller
public class CreateChannelController {
    @Autowired
    private CreateChannelService service;

    @GetMapping("/createChannel")
    public String getChannelPage() {

        return "createChannel";
    }

    @PostMapping("/createChannel")
    public String getChannel(ChannelDto form) {
//        , Authentication authentication, Model model
//        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//        model.addAttribute("user", userDetails.getUser());
        service.createChannel(form);
        return "redirect:/createChannel";
    }
}
