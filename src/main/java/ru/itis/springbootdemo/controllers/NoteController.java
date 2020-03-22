package ru.itis.springbootdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NoteController {
    @GetMapping("/note")
    public String getHelp() {
        return "note";
    }
}
