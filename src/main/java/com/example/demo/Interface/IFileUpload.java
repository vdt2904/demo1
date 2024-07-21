package com.example.demo.Interface;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IFileUpload {
    String uploadfile(MultipartFile file) throws IOException;
}
