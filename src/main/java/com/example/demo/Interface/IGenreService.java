package com.example.demo.Interface;

import com.example.demo.Entity.Genre;
import com.example.demo.dtos.GenreDto;

import java.util.List;

public interface IGenreService {
    List<GenreDto> getAllGenres();
    Genre getGenreById(Long id);
    Genre createGenre(Genre genre);
    Genre updateGenre(Long id, Genre genre);
    void deleteGenre(Long id);
}
