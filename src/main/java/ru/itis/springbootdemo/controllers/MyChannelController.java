package ru.itis.springbootdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyChannelController {
    @GetMapping("/myChannel")
    public String getHelp() {
        return "myChannel";
    }
}
