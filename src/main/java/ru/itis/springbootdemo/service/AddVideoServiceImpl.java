package ru.itis.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.dto.VideoDto;
import ru.itis.springbootdemo.models.Channel;
import ru.itis.springbootdemo.models.Video;
import ru.itis.springbootdemo.repositories.ChannelsRepository;
import ru.itis.springbootdemo.repositories.VideoRepository;

import java.time.LocalDateTime;
@Component
public class AddVideoServiceImpl implements AddVideoService {
    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private ChannelsRepository channelsRepository;

    @Override
    public void addVideo(VideoDto form, Long id) {
        Channel channel = channelsRepository.findOneByUserId(id);
        form.setChannel(channel);
        Video video = Video.builder().
                name(form.getName())
                .createdAt(LocalDateTime.now())
                .description(form.getDescription())
                .channel(form.getChannel())
                .img(fileStorageService.saveFile(form.getImg()))
                .video(fileStorageService.saveFile(form.getVideo()))
                .build();
        videoRepository.save(video);
    }
}
