package com.example.demo.Interface;

import com.example.demo.dtos.UserServicePriceDto;

import java.util.List;

public interface IUserServicePriceService {
    List<UserServicePriceDto> findUserSubsWithServicePriceLessThan(double price);
}
