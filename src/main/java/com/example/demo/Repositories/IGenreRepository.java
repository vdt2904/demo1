package com.example.demo.Repositories;

import com.example.demo.Entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenreRepository extends JpaRepository<Genre, Long> {
    @Query("select g from Genre g where g.Name = :name")
    Genre findByName(@Param("name") String name);
}
