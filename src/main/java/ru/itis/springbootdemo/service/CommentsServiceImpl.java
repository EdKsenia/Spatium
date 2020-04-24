package ru.itis.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.springbootdemo.dto.CommentDto;
import ru.itis.springbootdemo.models.Comment;
import ru.itis.springbootdemo.repositories.CommentsRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

    @Override
    public List<Comment> getComments(Long id) {
        return commentsRepository.findAllByVideoId(id);
    }

    @Override
    public void addComment(CommentDto form) {
        Comment comment = Comment.builder()
                 .createdAt(LocalDateTime.now())
                .user(form.getUser())
                .text(form.getText())
                .video(form.getVideo())
                .build();
        commentsRepository.save(comment);
    }
}
