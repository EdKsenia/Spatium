package ru.itis.springbootdemo.service;

import ru.itis.springbootdemo.dto.VideoDto;
import ru.itis.springbootdemo.models.Video;

import java.util.List;

public interface VideoService {

    List<Video> getVideos(Long id);

    VideoDto getConcreteVideo(Long videoId);

    List<VideoDto> search(String name);

    void delete(Long id);
}
