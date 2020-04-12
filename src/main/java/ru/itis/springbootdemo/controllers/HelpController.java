package ru.itis.springbootdemo.controllers;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.security.core.Authentication;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PostMapping;
        import ru.itis.springbootdemo.dto.HelpMessageDto;
        import ru.itis.springbootdemo.models.HelpMessage;
        import ru.itis.springbootdemo.models.User;
        import ru.itis.springbootdemo.security.UserDetailsImpl;
        import ru.itis.springbootdemo.service.HelpService;

@Controller
public class HelpController {
    @Autowired
    private HelpService service;

    @GetMapping("/help")
    public String getHelp(Authentication authentication, Model model) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        model.addAttribute("user", userDetails.getUser());
        return "help";
    }

    @PostMapping("/help")
    public String getChannel(Authentication authentication, HelpMessageDto form) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        form.setUser(user);
        service.help(form);
        return "redirect:/help";
    }
}
