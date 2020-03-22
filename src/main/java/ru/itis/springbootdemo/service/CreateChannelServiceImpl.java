package ru.itis.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.springbootdemo.dto.ChannelDto;
import ru.itis.springbootdemo.models.Channel;
import ru.itis.springbootdemo.repositories.ChannelsRepository;

@Component
public class CreateChannelServiceImpl implements CreateChannelService{

    @Autowired
    private ChannelsRepository channelsRepository;

    @Override
    public void createChannel(ChannelDto form) {
        Channel channel = Channel.builder()
                .name(form.getName())
                .about(form.getAbout())
                .img(form.getImg())
                .build();

        channelsRepository.save(channel);

    }
}
