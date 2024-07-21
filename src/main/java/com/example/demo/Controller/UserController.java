package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Interface.IUserService;
import com.example.demo.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @PostMapping()
    public User addUser(@RequestBody UserDto user) {

       return userService.createUser(user);
    }
    @GetMapping()
    public List<User> getUsers() {
        return userService.getUsers();
    }

}
