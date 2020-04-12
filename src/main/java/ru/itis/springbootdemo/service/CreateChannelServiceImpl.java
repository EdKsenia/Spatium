package ru.itis.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.dto.ChannelDto;
import ru.itis.springbootdemo.models.Channel;
import ru.itis.springbootdemo.models.User;
import ru.itis.springbootdemo.repositories.ChannelsRepository;
import ru.itis.springbootdemo.repositories.UsersRepository;

import java.time.LocalDateTime;

@Component
public class CreateChannelServiceImpl implements CreateChannelService {
    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private UsersRepository usersRepository;


    @Autowired
    private ChannelsRepository channelsRepository;

    @Override
    public void createChannel(ChannelDto channelDto) {
        Channel channel = Channel.builder().
                name(channelDto.getName())
                .createdAt(LocalDateTime.now())
                .about(channelDto.getAbout())
                .user(channelDto.getUser())
                .fileInfo(fileStorageService.saveFile(channelDto.getFile()))
                .build();
        channelsRepository.save(channel);
    }
}
