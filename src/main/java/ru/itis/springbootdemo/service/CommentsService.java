package ru.itis.springbootdemo.service;

import ru.itis.springbootdemo.dto.CommentDto;
import ru.itis.springbootdemo.models.Comment;

import java.util.List;

public interface CommentsService {
    List<Comment> getComments(Long id);
    void addComment(CommentDto form);
}
