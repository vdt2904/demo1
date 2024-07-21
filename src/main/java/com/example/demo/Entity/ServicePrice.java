package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "serviceprice")
public class ServicePrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "serviceid")
    private int serviceid;
    @Column(name = "serviceprice")
    private double serviceprice;
    @Column(name = "usedtime")
    private int usedtime;
}
