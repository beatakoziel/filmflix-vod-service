package com.filmflix.vodservice.controllers;

import com.filmflix.vodservice.db.entities.Movie;
import com.filmflix.vodservice.services.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;

import java.util.List;

@RestController
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping(produces = "application/json", value="/movies")
    public ResponseEntity<List<Movie>> getMovies(Authentication authentication) {
        return ResponseEntity.ok(movieService.getMovies());
    }
}
