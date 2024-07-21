package com.example.demo.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationDto {
    private String email;
    private String password;
}
