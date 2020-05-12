package ru.itis.springbootdemo.service;

import ru.itis.springbootdemo.dto.ChangeUserDto;
import ru.itis.springbootdemo.dto.SignUpDto;

public interface ChangeProfileService {
    void changeProfile(ChangeUserDto form, Long id);
}
