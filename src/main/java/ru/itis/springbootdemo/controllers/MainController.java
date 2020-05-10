package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itis.springbootdemo.models.Video;
import ru.itis.springbootdemo.service.VideoService;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private VideoService videoService;
    @GetMapping("/main")
    public String getMainPage(Model model) {
        List<Video> videos = videoService.getAll();
        model.addAttribute("videos", videos);
        return "main";
    }

  }
