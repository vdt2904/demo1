package com.example.demo.Interface;

import com.example.demo.Entity.User;
import com.example.demo.dtos.UserDto;

import java.util.List;

public interface IUserService {
    User createUser(UserDto user);
    List<User> getUsers();

}
