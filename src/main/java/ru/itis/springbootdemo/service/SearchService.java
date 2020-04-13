package ru.itis.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.springbootdemo.dto.VideoSearchResults;
import ru.itis.springbootdemo.repositories.VideoRepository;


public interface SearchService {
    VideoSearchResults searchVideos(String query, Integer page, Integer size);


}
