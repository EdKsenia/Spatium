package ru.itis.springbootdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddNoteController {
    @GetMapping("/addNote")
    public String getAddNotePage() {
        return "addNote";
    }
}
