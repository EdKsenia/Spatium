package ru.itis.springbootdemo.controllers;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelpController {

    @GetMapping("/help")
    public String getHelp() {
        return "help";
    }
}
