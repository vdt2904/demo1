package com.example.demo.Controller;

import com.example.demo.Interface.IFileUpload;
import com.example.demo.Interface.IUserServicePriceService;
import com.example.demo.dtos.UserServicePriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/UserServicePrice")
public class UserServicePriceController {
    @Autowired
    private IUserServicePriceService userSubService;
    @Autowired
    public UserServicePriceController(IUserServicePriceService userServicePriceService) {
        this.userSubService = userServicePriceService;
    }
    @Autowired
    private IFileUpload iFileUpload;
    @GetMapping("/{price}")
    public List<UserServicePriceDto> getUserSubsWithServicePriceLessThan(@PathVariable double price) {
        return userSubService.findUserSubsWithServicePriceLessThan(price);
    }


    @PostMapping(value = "/image", consumes = "multipart/form-data")
    public Object uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            return iFileUpload.uploadfile(file);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image");
        }
    }
}
