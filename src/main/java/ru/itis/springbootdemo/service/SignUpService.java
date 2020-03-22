package ru.itis.springbootdemo.service;

import ru.itis.springbootdemo.dto.SignUpDto;

public interface SignUpService {
    void signUp(SignUpDto form);
}
