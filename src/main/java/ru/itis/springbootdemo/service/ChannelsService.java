package ru.itis.springbootdemo.service;

import ru.itis.springbootdemo.dto.ChannelDto;
import ru.itis.springbootdemo.dto.InformationChannelDto;
import ru.itis.springbootdemo.models.Channel;

import java.util.List;

public interface ChannelsService {


    List<ChannelDto> getChannels();

    Channel getConcreteChannelByUserId(Long userId);

    Channel getConcreteChannelByChannelId(Long channelId);

    List<ChannelDto> search(String name);

    InformationChannelDto getInformation(Long channelId);

}
