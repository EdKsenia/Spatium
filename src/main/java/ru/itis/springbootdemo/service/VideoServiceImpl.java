package ru.itis.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.springbootdemo.dto.VideoDto;
import ru.itis.springbootdemo.models.Video;
import ru.itis.springbootdemo.repositories.VideoRepository;

import java.util.List;

import static ru.itis.springbootdemo.dto.VideoDto.from;

@Service
public class VideoServiceImpl implements VideoService{

    @Autowired
    private VideoRepository videoRepository;


    @Override
    public List<Video> getVideos(Long id) {
        return videoRepository.findAllByChannelId(id);
    }

    @Override
    public VideoDto getConcreteVideo(Long videoId) {
        Video video = videoRepository.findOneById(videoId);
        return from(video);
    }

    @Override
    public List<VideoDto> search(String name) {
        return null;
    }

    @Override
    public void delete(Long id) {
        videoRepository.deleteById(id);
    }
}
