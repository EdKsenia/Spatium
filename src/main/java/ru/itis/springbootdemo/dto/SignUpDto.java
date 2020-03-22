package ru.itis.springbootdemo.dto;

import lombok.Data;

@Data
public class SignUpDto {
    private String name;
    private String email;
    private String born;
    private String about;
    private String password;
}
