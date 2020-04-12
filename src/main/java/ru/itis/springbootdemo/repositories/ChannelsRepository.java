package ru.itis.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springbootdemo.models.Channel;
import ru.itis.springbootdemo.models.User;


import java.util.Optional;

public interface ChannelsRepository extends JpaRepository<Channel, Long> {
    Channel findOneByUserId(Long user);
    Channel findOneById(Long id);
}
