package ru.itis.springbootdemo.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface FileStorageService {
    String saveFile(MultipartFile file);

    void writeFileToResponse(String fileName, HttpServletResponse response);
}
