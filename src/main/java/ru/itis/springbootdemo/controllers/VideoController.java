package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.springbootdemo.dto.VideoDto;
import ru.itis.springbootdemo.models.Channel;
import ru.itis.springbootdemo.models.Video;
import ru.itis.springbootdemo.repositories.ChannelsRepository;
import ru.itis.springbootdemo.repositories.VideoRepository;
import ru.itis.springbootdemo.security.UserDetailsImpl;
import ru.itis.springbootdemo.service.VideoService;

@Controller
public class VideoController {
//    @GetMapping("/note")
//    public String getNotePage() {
//        return "note";
//    }

    @Autowired
    private ChannelsRepository channelsRepository;

    @Autowired
    private VideoService videoService;

    @Autowired
    private VideoRepository videoRepository;

    @GetMapping("/note{note-id}")
    public String getConcreteNotePage(@PathVariable("note-id") Long noteId, Authentication authentication, Model model) {
        if (authentication != null) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            model.addAttribute("user", userDetails.getUser());
            Channel channel = channelsRepository.findOneById(userDetails.getUser().getId());
            model.addAttribute("channel", channel);
//            VideoDto video = videoService.getConcreteVideo(noteId);
            Video video = videoRepository.getOne(noteId);
            model.addAttribute("video", video);
            return "note";
        }
        return "myChannel";
    }
}
