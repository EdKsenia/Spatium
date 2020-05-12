package ru.itis.springbootdemo.service;

import ru.itis.springbootdemo.dto.ChangeUserDto;
import ru.itis.springbootdemo.dto.SignUpDto;

public interface ChangeProfile {
    void changeProfile(ChangeUserDto form, Long id);
}
