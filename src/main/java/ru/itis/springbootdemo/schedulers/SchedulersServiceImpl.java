package ru.itis.springbootdemo.schedulers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.springbootdemo.models.Video;
import ru.itis.springbootdemo.repositories.VideoRepository;

import java.util.List;

@Service
public class SchedulersServiceImpl implements SchedulersService{
    @Autowired
    private VideoRepository videoRepository;

    @Override
    public List<Video> getLast5() {
        return videoRepository.findLast5Video();
    }

//    @Override
//    public void saveStatistic(List<Video> videos) {
//
//    }
}
