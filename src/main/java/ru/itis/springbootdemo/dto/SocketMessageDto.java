package ru.itis.springbootdemo.dto;

import lombok.Data;

@Data
public class SocketMessageDto {
    private String text;
    private String from;
}
