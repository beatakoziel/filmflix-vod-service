package com.filmflix.vodservice.services;

import com.filmflix.vodservice.db.entities.Movie;
import com.filmflix.vodservice.db.entities.Opinion;
import com.filmflix.vodservice.db.entities.User;
import com.filmflix.vodservice.db.repositories.MovieRepository;
import com.filmflix.vodservice.db.repositories.OpinionRepository;
import com.filmflix.vodservice.db.repositories.UserRepository;
import com.filmflix.vodservice.utilities.MovieNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OpinionService {

    private final OpinionRepository opinionRepository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    public Long addOpinion(String username, String comment, Long movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new MovieNotFoundException(movieId));
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        Opinion opinion = opinionRepository.save(
                Opinion.builder()
                        .comment(comment)
                        .user(user)
                        .build());
        movie.getOpinions().add(opinion);
        movieRepository.save(movie);
        return opinion.getId();
    }
}
