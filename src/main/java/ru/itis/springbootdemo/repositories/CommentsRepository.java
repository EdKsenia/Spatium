package ru.itis.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springbootdemo.models.Comment;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comment, Long> {
        List<Comment> findAllByVideoId(Long video);
}
