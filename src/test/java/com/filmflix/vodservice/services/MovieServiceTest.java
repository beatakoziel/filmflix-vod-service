package com.filmflix.vodservice.services;

import com.filmflix.vodservice.db.entities.Movie;
import com.filmflix.vodservice.db.entities.Opinion;
import com.filmflix.vodservice.db.repositories.MovieRepository;
import com.filmflix.vodservice.utilities.exceptions.MovieNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static com.filmflix.vodservice.utilities.TestBuilders.buildMovie;
import static com.filmflix.vodservice.utilities.TestBuilders.buildOpinion;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class MovieServiceTest {

    @InjectMocks
    private MovieService movieService;

    @Mock
    private MovieRepository movieRepository;

    @Before
    public void setUp() {
        Movie movie1 = buildMovie(1L);
        Movie movie2 = buildMovie(2L);
        Opinion opinion = buildOpinion();
        movie1.getOpinions().add(opinion);
        List<Movie> moviesList = new ArrayList<>();
        moviesList.add(movie1);
        moviesList.add(movie2);
        when(movieRepository.findAll()).thenReturn(moviesList);
        when(movieRepository.findById(1L)).thenReturn(java.util.Optional.of(movie1));
    }

    @Test
    public void getMovies_ShouldReturnListWithTwoMovies() {
        List<Movie> movies = movieService.getMovies();
        assertThat(movies.size()).isEqualTo(2L);
/*        assertThat(movies.get(0).getId()).isEqualTo(1L);
        assertThat(movies.get(0).getTitle()).isEqualTo(MOVIE_TEST_TITLE);
        assertThat(movies.get(0).getOpinions()).isNotNull();
        assertThat(movies.get(0).getDescription()).isEqualTo(MOVIE_TEST_DESCRIPTION);
        assertThat(movies.get(0).getCoverUri()).isEqualTo(MOVIE_TEST_COVER_URI);
        assertThat(movies.get(0).getResourceUri()).isEqualTo(MOVIE_TEST_RESOURCE_URI);*/
    }

    @Test
    public void getOpinions_shouldReturnListWithOneOpinion() {
        List<Opinion> opinions = movieService.getMovieOpinions(1L);
        assertThat(opinions.size()).isEqualTo(1L);
    }

    @Test
    public void getOpinions_shouldReturnMovieNotFoundException() {
        assertThrows(MovieNotFoundException.class,
                () -> movieService.getMovieOpinions(2L));
    }

}
