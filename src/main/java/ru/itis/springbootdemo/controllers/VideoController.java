package ru.itis.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.itis.springbootdemo.dto.CommentDto;
import ru.itis.springbootdemo.dto.VideoDto;
import ru.itis.springbootdemo.models.Channel;
import ru.itis.springbootdemo.models.Comment;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.models.Video;
import ru.itis.springbootdemo.repositories.ChannelsRepository;
import ru.itis.springbootdemo.repositories.VideoRepository;
import ru.itis.springbootdemo.security.UserDetailsImpl;
import ru.itis.springbootdemo.service.CommentsService;
import ru.itis.springbootdemo.service.VideoService;

import javax.validation.Valid;
import java.util.List;

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

    @Autowired
    private CommentsService commentsService;

    @GetMapping("/note{note-id}")
    public String getConcreteNotePage(@PathVariable("note-id") Long noteId, Authentication authentication, Model model) {
        if (authentication != null) {
            Video video = videoRepository.getOne(noteId);
            model.addAttribute("video", video);
            Channel channel = video.getChannel();
            User user = channel.getUser();
            model.addAttribute("user", user);
            model.addAttribute("channel", channel);
//            Video prev = videoRepository.getOne(noteId - 1);
//            if(prev!=null){
//                model.addAttribute("prev", prev);
//            }
//            Video next = videoRepository.getOne(noteId + 1);
//            if(next!=null){
//                model.addAttribute("next", next);
//            }
//            VideoDto video = videoService.getConcreteVideo(noteId);
            List<Comment> comments = commentsService.getComments(noteId);

            model.addAttribute("comments", comments);
            return "note";
        }
        return "myChannel";
    }

    @PostMapping("/comment{note-id}")
    public String addComment(@PathVariable("note-id") Long noteId, Authentication authentication, CommentDto form) {
        if (authentication != null) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            form.setUser(userDetails.getUser());
            Video video = videoRepository.getOne(noteId);
            form.setVideo(video);
            commentsService.addComment(form);
        }
        return "redirect:/note" + noteId;
    }

    @PostMapping("/deleteNote{note-id}")
    public String deleteVideo(@PathVariable("note-id") Long noteId, Authentication authentication){
        if (authentication != null) {
            Video video = videoRepository.getOne(noteId);
            videoService.delete(video.getId());
        }
        return "redirect:/myChannel";
    }
}
