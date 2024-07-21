package com.example.demo.dtos;

import jakarta.persistence.Column;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDate;

@Data
public class UserDto {
    private String username;
    private String password;
    private String email;
    private LocalDate joindate;
    private int roleid;
    public UserDto(String username, String password, String email, LocalDate joindate, int roleid) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.joindate = joindate;
        this.roleid = roleid;
    }
}
