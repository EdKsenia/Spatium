package ru.itis.springbootdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VideoController {
    @GetMapping("/note")
    public String getNotePage() {
        return "note";
    }
}
