package com.filmflix.vodservice.services;

import com.filmflix.vodservice.db.entities.Movie;
import com.filmflix.vodservice.db.repositories.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public List<Movie> getMovies() { return movieRepository.findAll(); }
}
