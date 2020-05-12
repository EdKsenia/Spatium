package ru.itis.springbootdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.springbootdemo.dto.ChannelDto;
import ru.itis.springbootdemo.dto.InformationChannelDto;
import ru.itis.springbootdemo.models.Channel;
import ru.itis.springbootdemo.repositories.ChannelsRepository;

import java.util.List;

import static ru.itis.springbootdemo.dto.ChannelDto.from;

@Service
public class ChannelsServiceImpl implements ChannelsService {

    @Autowired
    private ChannelsRepository channelsRepository;

    @Override
    public List<ChannelDto> getChannels() {
        return from(channelsRepository.findAll());
    }

    @Override
    public Channel getConcreteChannelByUserId(Long userId) {
        Channel channel = channelsRepository.findOneByUserId(userId);
        return channel;
    }

    @Override
    public Channel getConcreteChannelByChannelId(Long channelId) {
        Channel channel = channelsRepository.findOneById(channelId);
        return channel;
    }

    @Override
    public List<ChannelDto> search(String name) {
        return null;
    }

    @Override
    public InformationChannelDto getInformation(Long channelId) {
        return channelsRepository.getInformationByChannel(channelId);
    }

//    @Override
//    public void create(ChannelDto channelDto) {
//        Channel channel = Channel.builder().
//                name(channelDto.getName())
//                .createdAt(LocalDateTime.now())
//                .about(channelDto.getAbout())
//                .user(channelDto.getUser())
//                .fileInfo(fileStorageService.saveFile(channelDto.getFile()))
//                .build();
//        channelsRepository.save(channel);
//    }
}
