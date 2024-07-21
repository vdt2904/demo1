package com.example.demo.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repositories.IUserRepository;
import com.example.demo.Utils.JwtUtil;
import com.example.demo.dtos.AuthenticationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtService {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private IUserRepository IUserRepository;

    public String authenticate(AuthenticationDto authenticationDto) {

        boolean isValidUser = authenticateUser(authenticationDto);
        if (isValidUser) {
            // Nếu xác thực thành công, tạo token
            return jwtUtil.generateToken(authenticationDto.getEmail());
        }
        throw new RuntimeException("Invalid username or password");
    }
    private boolean authenticateUser(AuthenticationDto authenticationDto) {
        User user = IUserRepository.findByEmail(authenticationDto.getEmail());
        PasswordEncoder encoder = new BCryptPasswordEncoder(10);
        if(encoder.matches(authenticationDto.getPassword(),user.getPassword())){
            return true;
        }
        return false;
    }
}
