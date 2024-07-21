package com.example.demo.Controller;

import com.example.demo.Service.JwtService;
import com.example.demo.dtos.AuthenticationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jwt")
public class JwtController {
    @Autowired
    private JwtService jwtService;

    @PostMapping
    public String createToken(@RequestBody() AuthenticationDto authentication) {
        return jwtService.authenticate(authentication);
    }
}
