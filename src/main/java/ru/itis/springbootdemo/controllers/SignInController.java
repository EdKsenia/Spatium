package ru.itis.springbootdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SignInController {

    @GetMapping("/signIn")
    public String getSignIn() {
        return "sign_in";
    }

//    @Autowired
//    private SignInService signInService;

//    @GetMapping("/signIn")
//    public String getSignIn(@RequestParam(value = "error", required = false)
//                            String error, Model model) {
//        if (error != null){
//            model.addAttribute("error", true);
//        }
//        return "sign_in";
//    }

//    @PostMapping("/signIn")
//    public String signIn(@RequestParam("email") String email,
//                         @RequestParam("password") String password,
//                         HttpServletResponse response) {
//        String cookieValue = signInService.signIn(email, password);
//
//        if (cookieValue == null) {
//            return "redirect:/signIn?error";
//        }
//
//        Cookie cookie = new Cookie("AuthCookie", cookieValue);
//        response.addCookie(cookie);
//        return "redirect:/users";
//    }

}
