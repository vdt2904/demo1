package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genreid") // Đổi tên column thành "GenreId"
    private long GenreId;

    @Column(name = "name", length = 100)
    private String Name;
}

