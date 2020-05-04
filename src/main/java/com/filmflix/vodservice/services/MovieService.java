package com.filmflix.vodservice.services;

import com.filmflix.vodservice.db.entities.Movie;
import com.filmflix.vodservice.db.entities.Opinion;
import com.filmflix.vodservice.db.repositories.MovieRepository;
import com.filmflix.vodservice.utilities.MovieNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    public List<Opinion> getMovieOpinions(Long movieId) {
        return movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException(movieId))
                .getOpinions();
    }
}
