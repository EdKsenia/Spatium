package ru.itis.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springbootdemo.models.Channel;
import ru.itis.springbootdemo.models.Video;

import java.util.Optional;

public interface VideoRepository extends JpaRepository<Video, Long> {
    Optional<Video> findOneByChannelId(Long channel);
    Video findOneById(Long id);
}
