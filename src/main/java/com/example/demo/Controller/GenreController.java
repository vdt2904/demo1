package com.example.demo.Controller;
import com.example.demo.Entity.Genre;
import com.example.demo.Interface.IGenreService;
import com.example.demo.Interface.IRedisService;
import com.example.demo.dtos.GenreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenreController {
    @Autowired
    private IGenreService genreService;
    @Autowired
    private IRedisService redisService;
    @GetMapping
    public List<GenreDto> getAllGenres() {
        List<GenreDto> genres = redisService.getData("genres", List.class);
        if (genres == null) {
            return genreService.getAllGenres();
        }
        return genres;
    }

    @GetMapping("/{id}")
    public Object getGenreById(@PathVariable("id") Long id) {
        try {
            Genre genre = genreService.getGenreById(id);
            return ResponseEntity.ok(genre);

        }catch (RuntimeException e){
            return e.getMessage();
        }
    }

    @PostMapping
    public Object createGenre(@RequestBody Genre genre) {
        try{
            return new ResponseEntity<>(genreService.createGenre(genre), HttpStatus.CREATED);
        }catch (RuntimeException e){
            return e.getMessage();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Genre> updateGenre(@PathVariable("id") Long id, @RequestBody Genre genre) {
        Genre updatedGenre = genreService.updateGenre(id, genre);
        if (updatedGenre == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedGenre);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteGenre(@PathVariable("id") Long id) {
        genreService.deleteGenre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
