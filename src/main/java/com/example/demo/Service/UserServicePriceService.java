package com.example.demo.Service;

import com.example.demo.Interface.IUserServicePriceService;
import com.example.demo.Repositories.IUserServicePriceRepository;
import com.example.demo.dtos.UserServicePriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServicePriceService implements IUserServicePriceService {
    private IUserServicePriceRepository priceRepository;
    @Autowired
    public UserServicePriceService(IUserServicePriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }
    @Override
    public List<UserServicePriceDto> findUserSubsWithServicePriceLessThan(double price) {
        return priceRepository.findUserServicePrice(10000);
    }
}
