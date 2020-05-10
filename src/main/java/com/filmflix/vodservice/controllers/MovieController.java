package com.filmflix.vodservice.controllers;

import com.filmflix.vodservice.db.entities.Movie;
import com.filmflix.vodservice.db.entities.Opinion;
import com.filmflix.vodservice.db.entities.User;
import com.filmflix.vodservice.services.MovieService;
import com.filmflix.vodservice.services.OpinionService;
import com.filmflix.vodservice.services.VideoService;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.ResourceRegion;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/movies")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081",
        "http://localhost:8082", "http://localhost:8083"})
public class MovieController {

    private final MovieService movieService;
    private final VideoService videoService;
    private final OpinionService opinionService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Movie>> getMovies() {
        return ResponseEntity.ok(movieService.getMovies());
    }

    @GetMapping(produces = "application/json", value = "/{movieId}/opinions")
    public ResponseEntity<List<Opinion>> getMovieOpinions(@PathVariable Long movieId) {
        return ResponseEntity.ok(movieService.getMovieOpinions(movieId));
    }

    @PutMapping("/{movieId}/opinions")
    public void addOpinion(Authentication authentication, String comment, @PathVariable Long movieId) {
        opinionService.addOpinion(((User) authentication.getPrincipal()).getUsername(), comment, movieId);
    }

    @GetMapping("/videos/{name}")
    public ResponseEntity<ResourceRegion> getVideo(@PathVariable String name, @RequestHeader HttpHeaders headers) throws IOException {
        val video = new UrlResource("file:videos/" + name + ".mp4");
        val region = videoService.resourceRegion(video, headers);
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
                .contentType(MediaTypeFactory
                        .getMediaType(video)
                        .orElse(MediaType.APPLICATION_OCTET_STREAM))
                .body(region);
    }
}
