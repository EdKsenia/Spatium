package ru.itis.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springbootdemo.models.Channel;


import java.util.Optional;

public interface ChannelsRepository extends JpaRepository<Channel, Long> {
    Optional<Channel> findByOwned(long owned);
}
