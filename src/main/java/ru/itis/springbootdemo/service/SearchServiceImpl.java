package ru.itis.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.itis.springbootdemo.dto.VideoDto;
import ru.itis.springbootdemo.dto.VideoSearchResults;
import ru.itis.springbootdemo.models.Video;
import ru.itis.springbootdemo.repositories.VideoRepository;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private VideoRepository videoRepository;

    @Override
    public VideoSearchResults searchVideos(String query, Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Video> pageResult = videoRepository.search(query, pageRequest);
        List<VideoDto> videos = VideoDto.from(pageResult.getContent());
        return VideoSearchResults.builder()
                .videos(videos)
                .count(pageResult.getTotalPages())
                .build();
    }
}
