package ru.itis.springbootdemo.schedulers;

import ru.itis.springbootdemo.models.Video;

import java.util.List;

public interface SchedulersService {

    List<Video> getLast5();
//    List<Video> saveStatistic(List<Video> videos);
}
