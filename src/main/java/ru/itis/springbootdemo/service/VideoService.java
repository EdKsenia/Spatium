package ru.itis.springbootdemo.service;

import ru.itis.springbootdemo.dto.VideoDto;
import ru.itis.springbootdemo.models.Video;

import java.util.List;

public interface VideoService {

    List<Video> getVideos(Long id);

    List<Video> getAll();

    VideoDto getConcreteVideo(Long videoId);

    void delete(Long id);
}
