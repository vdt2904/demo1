package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "useservice")
public class UseService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "userid")
    private int userid;
    @Column(name = "serviceid")
    private int serviceid;
    @Column(name = "datecreate")
    private LocalDateTime datecreate;
    @Column(name = "dateexprired")
    private LocalDateTime  dateexpired;
}
