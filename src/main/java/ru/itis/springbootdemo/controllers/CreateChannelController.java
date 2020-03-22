package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.springbootdemo.dto.ChannelDto;
import ru.itis.springbootdemo.service.CreateChannelService;

@Controller
public class CreateChannelController {
    @Autowired
    private CreateChannelService service;

    @GetMapping("/createChannel")
    public String getWelcome() {
        return "createChannel";
    }

    @PostMapping("/createChannel")
    public String signUp(ChannelDto form) {
        service.createChannel(form);
        return "redirect:/createChannel";
    }
}
