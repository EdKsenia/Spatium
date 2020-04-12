package ru.itis.springbootdemo.service;

import ru.itis.springbootdemo.dto.ChannelDto;
import ru.itis.springbootdemo.models.Channel;

import java.util.List;

public interface ChannelsService {


    List<ChannelDto> getChannels();

    ChannelDto getConcreteChannel(Long channelId);

    List<ChannelDto> search(String name);

}
