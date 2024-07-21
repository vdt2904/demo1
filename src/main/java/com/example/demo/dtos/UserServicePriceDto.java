package com.example.demo.dtos;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserServicePriceDto {
    private int id;
    private int userId;
    private int serviceId;
    private String serviceName;
    private double serviceprice;
    private int usedtime;
    private LocalDateTime datecreate;
    public UserServicePriceDto(int id, int userId, int serviceId, String serviceName, double price, int usedTime, LocalDateTime dateCreate) {
        this.id = id;
        this.userId = userId;
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.serviceprice = price;
        this.usedtime = usedTime;
        this.datecreate = dateCreate;
    }
}
