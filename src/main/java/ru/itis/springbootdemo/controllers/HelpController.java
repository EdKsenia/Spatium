package ru.itis.springbootdemo.controllers;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.security.core.Authentication;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.*;
        import ru.itis.springbootdemo.dto.HelpMessageDto;
        import ru.itis.springbootdemo.models.HelpMessage;
        import ru.itis.springbootdemo.models.User;
        import ru.itis.springbootdemo.security.UserDetailsImpl;
        import ru.itis.springbootdemo.service.HelpService;
        import ru.itis.springbootdemo.service.SmsService;
        import ru.itis.springbootdemo.service.SmsServiceImpl;

@Controller
public class HelpController {
    @Autowired
    private HelpService service;

    @Autowired
    private SmsService smsService;

    @GetMapping("/help")
    public String getHelp(Authentication authentication, Model model) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        model.addAttribute("user", userDetails.getUser());
        return "help";
    }

    @ResponseBody
    @PostMapping("/help")
    public void getHelp(Authentication authentication, HelpMessageDto form, @RequestParam("phone") String phone) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        form.setUser(user);
        service.help(form);
//        return "ok";
    }

//    @ResponseBody
//    @RequestMapping(path = "/help", produces = "application/text; charset=UTF-8")
//    public String signUp(HelpMessageDto form) {
//        System.out.println(form.getCode() + form.getConfirmCode());
//        if (form.getCode().equals(form.getConfirmCode())) {
//            service.help(form);
//            return "ok";
//        }
//        else {
//            return "error";
//        }
//    }

    @ResponseBody
    @RequestMapping(path = "/help/sendMessage", produces = "application/text; charset=UTF-8")
    public String sendMessage(@RequestParam("phone") String phone) {
        return smsService.sendMessage(phone);
    }
}
