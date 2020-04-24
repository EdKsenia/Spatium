package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.springbootdemo.dto.ChannelDto;
import ru.itis.springbootdemo.dto.VideoDto;
import ru.itis.springbootdemo.models.Channel;
import ru.itis.springbootdemo.models.Video;
import ru.itis.springbootdemo.repositories.ChannelsRepository;
import ru.itis.springbootdemo.security.UserDetailsImpl;
import ru.itis.springbootdemo.service.ChannelsService;
import ru.itis.springbootdemo.service.VideoService;


import java.util.List;
import java.util.Optional;

@Controller
public class MyChannelController {

    @Autowired
    private ChannelsService channelsService;

    @Autowired
    private VideoService videoService;

    @GetMapping("/myChannel")
    public String getConcreteChannelPage(Authentication authentication, Model model) {
        if (authentication != null) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            model.addAttribute("user", userDetails.getUser());
//            Channel channel = channelsRepository.findOneById(userDetails.getUser().getId());
            Channel channel = channelsService.getConcreteChannel(userDetails.getUser().getId());
            model.addAttribute("channel", channel);
            List<Video> videos = videoService.getVideos(channel.getId());
            model.addAttribute("videos", videos);
            return "myChannel";
        }
        return "createChannel";
    }


}
