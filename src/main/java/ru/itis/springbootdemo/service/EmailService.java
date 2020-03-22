package ru.itis.springbootdemo.service;

public interface EmailService {
    void sendMail(String subject, String text, String email);
}
