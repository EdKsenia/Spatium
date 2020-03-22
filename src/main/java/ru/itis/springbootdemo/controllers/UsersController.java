package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.springbootdemo.dto.UserDto;
import ru.itis.springbootdemo.service.UsersService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/{user-id}")
    public String getConcreteUserPage(@PathVariable("user-id") Long userId, Model model) {
        UserDto user = usersService.getConcreteUser(userId);
        model.addAttribute("user", user);
        return "user_page";
    }

    @GetMapping
    public String getUsersPage(Model model) {
        List<UserDto> users = usersService.getUsers();
        model.addAttribute("users", users);
        return "users_page";
    }

    @GetMapping("/search")
    @ResponseBody
    public List<UserDto> searchUsers(@RequestParam("name") String name) {
        return usersService.search(name);
    }






//    @Autowired
//    private CookieServiceImpl cookieService;
//
//    @GetMapping("/{user-id}")
//    public String getConcreteUserPage(@PathVariable("user-id") Long userId, Model model) {
//        UserDto user = usersService.getConcreteUser(userId);
//        model.addAttribute("user", user);
//        return "user_page";
//    }
//
//    @GetMapping
//    public String getUsersPage(@CookieValue(value = "AuthCookie", required = false) String cookie,
//                               Model model) {
//        String cookieValue = cookieService.checkCookie(cookie);
//        if (cookieValue == null) {
//            return "redirect:/signIn";
//        }
//        List<UserDto> users = usersService.getUsers();
//        model.addAttribute("users", users);
//        return "users_page";
//    }
//
//    @GetMapping("/search")
//    @ResponseBody
//    public List<UserDto> searchUsers(@RequestParam("query") String name)
//    {
//        return usersService.search(name);
//    }


}
