package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.springbootdemo.dto.ChangeUserDto;
import ru.itis.springbootdemo.dto.ProfileForm;
import ru.itis.springbootdemo.models.Channel;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.security.UserDetailsImpl;
import ru.itis.springbootdemo.service.ChangeProfileService;
import ru.itis.springbootdemo.service.ChannelsService;

import javax.validation.Valid;

@Controller
public class ProfileController {
    @Autowired
    private ChannelsService channelsService;

    @Autowired
    private ChangeProfileService changeProfileService;

    @GetMapping("/profile")
    public String getProfile(Authentication authentication, Model model){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        model.addAttribute("user", userDetails.getUser());
        Channel channel = channelsService.getConcreteChannelByUserId(userDetails.getUser().getId());
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
    public String updateProfile(Authentication authentication,@Valid ChangeUserDto userDto,
                                BindingResult bindingResult, Model model) {
        System.out.println(userDto);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        model.addAttribute("user", user);
        System.out.println(bindingResult.getAllErrors());
        model.addAttribute("profileForm", userDto);
        if(!bindingResult.hasErrors()){
            changeProfileService.changeProfile(userDto, user.getId());
            return "profile";
        }
        else{
            return "changeProfile";
        }
    }

}
