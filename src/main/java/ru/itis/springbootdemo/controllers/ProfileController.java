package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.springbootdemo.dto.ProfileForm;
import ru.itis.springbootdemo.models.Channel;
import ru.itis.springbootdemo.security.UserDetailsImpl;
import ru.itis.springbootdemo.service.ChannelsService;

import javax.validation.Valid;

@Controller
public class ProfileController {
    @Autowired
    private ChannelsService channelsService;

    @GetMapping("/profile")
    public String getProfile(Authentication authentication, Model model){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        model.addAttribute("user", userDetails.getUser());
        Channel channel = channelsService.getConcreteChannel(userDetails.getUser().getId());
        model.addAttribute("channel", channel);
        model.addAttribute("profileForm", new ProfileForm());
        return "profile";
    }

    @GetMapping("/changeProfile")
    public String getChangeProfile(Authentication authentication, Model model) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        model.addAttribute("user", userDetails.getUser());
        model.addAttribute("profileForm", new ProfileForm());
        return "changeProfile";
    }

    @PostMapping("/changeProfile")
    public String updateProfile(Authentication authentication, @Valid ProfileForm form, BindingResult bindingResult, Model model) {
        System.out.println(form);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        model.addAttribute("user", userDetails.getUser());
        System.out.println(bindingResult.getAllErrors());
        model.addAttribute("profileForm", form);
        return "profile";
    }

}
