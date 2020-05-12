package ru.itis.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.springbootdemo.dto.InformationChannelDto;
import ru.itis.springbootdemo.models.Channel;
import ru.itis.springbootdemo.models.User;


import java.util.Optional;

public interface ChannelsRepository extends JpaRepository<Channel, Long> {
    Channel findOneByUserId(Long user);
    Channel findOneById(Long id);

    @Query("select new ru.itis.springbootdemo.dto.InformationChannelDto(channel.name, count(video)) from Channel channel left join channel.videos " +
            "as video where channel.id = :channelId group by channel.id")
    InformationChannelDto getInformationByChannel(@Param("channelId") Long id);
}
