package com.filmflix.vodservice.controllers;

import com.filmflix.vodservice.db.entities.Movie;
import com.filmflix.vodservice.db.entities.Opinion;
import com.filmflix.vodservice.db.entities.User;
import com.filmflix.vodservice.services.MovieService;
import com.filmflix.vodservice.services.OpinionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;
    private final OpinionService opinionService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Movie>> getMovies(Authentication authentication) {
        return ResponseEntity.ok(movieService.getMovies());
    }

    @GetMapping(produces = "application/json", value = "/{movieId}/opinions")
    public ResponseEntity<List<Opinion>> getMovieOpinions(@PathVariable Long movieId) {
        return ResponseEntity.ok(movieService.getMovieOpinions(movieId));
    }

    @PutMapping("/{movieId}/opinions")
    private void addOpinion(Authentication authentication, String comment, @PathVariable Long movieId) {
        System.out.println(((User) authentication.getPrincipal()).getUsername());
        System.out.println(comment);
        System.out.println(movieId);
        opinionService.addOpinion(((User) authentication.getPrincipal()).getUsername(), comment, movieId);
    }
}
