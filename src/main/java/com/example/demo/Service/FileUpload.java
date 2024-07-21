package com.example.demo.Service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.demo.Interface.IFileUpload;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FileUpload implements IFileUpload {
    private final Cloudinary cloudinary;
    @Override
    public String uploadfile(MultipartFile file) throws IOException {
        Map<String, String> options = ObjectUtils.asMap(
                "folder", "Test",
                "use_filename", "false",
                "public_id", "Test1"
        );

        return cloudinary.uploader().upload(file.getBytes(), options).toString();
    }
}
