package ru.itis.springbootdemo.service;

import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.springbootdemo.models.FileInfo;
import ru.itis.springbootdemo.repositories.FileInfoRepository;
import ru.itis.springbootdemo.util.FileStorageUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@Service
public class FileStorageServiceImpl implements FileStorageService {
    @Autowired
    private FileInfoRepository fileInfoRepository;

    @Autowired
    private FileStorageUtil fileStorageUtil;

    @Override
    public FileInfo saveFile(MultipartFile file) {
        FileInfo fileInfo = fileStorageUtil.convertFromMultipart(file);
        fileInfoRepository.save(fileInfo);
        fileStorageUtil.copyToStorage(file, fileInfo.getStorageFileName());
        return fileInfo;
    }

    @SneakyThrows
    @Override
    public void writeFileToResponse(String fileName, HttpServletResponse response) {
        FileInfo file = fileInfoRepository.findOneByStorageFileName(fileName);
        response.setContentType(file.getType());
        InputStream inputStream = new FileInputStream(new File(file.getUrl()));
        IOUtils.copy(inputStream, response.getOutputStream());
        response.flushBuffer();
    }
}
