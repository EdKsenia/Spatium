package ru.itis.springbootdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.springbootdemo.models.HelpMessage;

public interface HelpRepository extends JpaRepository<HelpMessage, Long> {
}
