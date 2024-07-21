package com.example.demo.Service;

import com.example.demo.Entity.Genre;
import com.example.demo.Interface.IGenreService;
import com.example.demo.Interface.IRedisService;
import com.example.demo.Repositories.IGenreRepository;
import com.example.demo.dtos.GenreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GenreService implements IGenreService
{
    @Autowired
    private IGenreRepository iGenreRepository;
    @Autowired
    private IRedisService redisService;
    @Override
    public List<GenreDto> getAllGenres() {
        List<Genre> genres = iGenreRepository.findAll();
        List<GenreDto> genresDto = genres.stream().map(this::convertToDTO).collect(Collectors.toList());
        redisService.saveData("genres", genres);
        redisService.setKeyExpiration("genres",1);
        return genresDto;
    }

    @Override
    public Genre getGenreById(Long id) {
        Optional<Genre> genre = iGenreRepository.findById(id);
        if (genre.isPresent()) {
            return genre.get();
        }
        throw new RuntimeException("Genre not found");
    }

    @Override
    public Genre createGenre(Genre genre) {
        if(genre.getName()==null || genre.getName().isEmpty()){
            throw new RuntimeException("Vui lòng nhập đầy đủ");
        }
        Genre genre1 = iGenreRepository.findByName(genre.getName());
        if(genre1!=null){
            throw new RuntimeException("Genre already exists");
        }
        Genre genre2 = iGenreRepository.save(genre);
        List<Genre> genres = iGenreRepository.findAll();
        List<GenreDto> genresDto = genres.stream().map(this::convertToDTO).collect(Collectors.toList());
        redisService.saveData("genres", genres);
        redisService.setKeyExpiration("genres",1);
        return genre2;
    }

    @Override
    public Genre updateGenre(Long id, Genre genre) {
        return null;
    }

    @Override
    public void deleteGenre(Long id) {

    }
    public GenreDto convertToDTO(Genre genre) {
        GenreDto genreDto = new GenreDto(genre.getGenreId(), genre.getName());
        return genreDto;
    }

}
