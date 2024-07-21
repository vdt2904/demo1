package com.example.demo.dtos;

import lombok.Data;

@Data

public class GenreDto {
    private long genreid;
    private String name;

    public GenreDto(long genreid, String name) {
        this.genreid = genreid;
        this.name = name;
    }
}
