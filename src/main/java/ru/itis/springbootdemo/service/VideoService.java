package ru.itis.springbootdemo.service;

import ru.itis.springbootdemo.dto.VideoDto;

import java.util.List;

public interface VideoService {

    List<VideoDto> getVideos();

    VideoDto getConcreteVideo(Long videoId);

    List<VideoDto> search(String name);
}
