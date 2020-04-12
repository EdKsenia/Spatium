package ru.itis.springbootdemo.service;

import ru.itis.springbootdemo.dto.VideoDto;

public interface AddVideoService {
    void addVideo(VideoDto form, Long id);
}
