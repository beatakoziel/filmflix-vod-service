package com.filmflix.vodservice.services;

import com.filmflix.vodservice.db.entities.Movie;
import com.filmflix.vodservice.db.entities.Opinion;
import com.filmflix.vodservice.db.entities.User;
import com.filmflix.vodservice.db.repositories.MovieRepository;
import com.filmflix.vodservice.db.repositories.OpinionRepository;
import com.filmflix.vodservice.db.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static com.filmflix.vodservice.utilities.TestBuilders.*;
import static com.filmflix.vodservice.utilities.TestConstants.OPINION_COMMENT_TEST;
import static com.filmflix.vodservice.utilities.TestConstants.USER_TEST_EMAIL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class OpinionServiceTest {

    @InjectMocks
    private OpinionService opinionService;
    @Mock
    private OpinionRepository opinionRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private MovieRepository movieRepository;

    @Before
    public void setUp() {
        User user = buildUser();
        Movie movie = buildMovie(1L);
        Opinion opinion = buildOpinion();
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(user));
        when(movieRepository.findById(anyLong())).thenReturn(Optional.of(movie));
        when(opinionRepository.save(any(Opinion.class))).thenReturn(opinion);
    }

    @Test
    public void addOpinion_shouldReturnOpinionId() {
        Long id = opinionService.addOpinion(USER_TEST_EMAIL, OPINION_COMMENT_TEST, 1L);
        assertThat(id).isEqualTo(1L);
    }

}
