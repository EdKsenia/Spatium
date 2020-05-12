package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.springbootdemo.dto.InformationChannelDto;
import ru.itis.springbootdemo.models.Channel;
import ru.itis.springbootdemo.models.Video;
import ru.itis.springbootdemo.security.UserDetailsImpl;
import ru.itis.springbootdemo.service.ChannelsService;
import ru.itis.springbootdemo.service.VideoService;


import java.util.List;

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
            Channel channel = channelsService.getConcreteChannelByUserId(userDetails.getUser().getId());
            if(channel!=null){
                model.addAttribute("channel", channel);
                List<Video> videos = videoService.getVideos(channel.getId());
                model.addAttribute("videos", videos);
                return "myChannel";
            }
            else{
                return "createChannel";
            }

        }
        return "createChannel";
    }

    @GetMapping("channel/{channel-id}/information")
    public ResponseEntity<InformationChannelDto> getInformation(@PathVariable("channel-id") Long channelId) {
        InformationChannelDto result = channelsService.getInformation(channelId);
        return ResponseEntity.ok(result);
    }


}
