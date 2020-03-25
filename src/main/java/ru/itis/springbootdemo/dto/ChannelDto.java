package ru.itis.springbootdemo.dto;

import lombok.Data;
import ru.itis.springbootdemo.models.User;

@Data
public class ChannelDto {
    private String name;
    private String about;
    private String img;
    private User user;
}
