package com.example.demo.Service;

import com.example.demo.Entity.User;
import com.example.demo.Interface.IUserService;
import com.example.demo.Repositories.IUserRepository;
import com.example.demo.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository userRepository;
    @Override
    public User createUser(UserDto user) {
        if(userRepository.findByUsername(user.getEmail()) != null) {
            throw new RuntimeException("Username already exists");
        }
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setEmail(user.getEmail());
        newUser.setJoindate(user.getJoindate());
        newUser.setRoleid(user.getRoleid());
        return userRepository.save(newUser);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

}
