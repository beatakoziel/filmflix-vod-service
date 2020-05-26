package com.filmflix.vodservice.controllers;

import com.filmflix.vodservice.configurations.security.jwt.JwtAuthenticationFilter;
import com.filmflix.vodservice.configurations.security.jwt.JwtUtil;
import com.filmflix.vodservice.db.entities.Movie;
import com.filmflix.vodservice.db.entities.Opinion;
import com.filmflix.vodservice.db.repositories.MovieRepository;
import com.filmflix.vodservice.dtos.requests.RegisterRequest;
import com.filmflix.vodservice.services.MovieService;
import com.filmflix.vodservice.services.UserService;
import com.filmflix.vodservice.services.VideoService;
import com.jayway.jsonpath.JsonPath;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static com.filmflix.vodservice.utilities.TestBuilders.*;
import static com.filmflix.vodservice.utilities.TestConstants.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MovieControllerTest {

    private MockMvc mockMvc;
    @Autowired
    private JwtUtil jwtUtil;
    @MockBean
    private UserService userService;
    @Autowired
    private WebApplicationContext context;
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;
    @MockBean
    private AuthenticationManager authenticationManager;
    @Autowired
    private MovieService movieService;
    @Autowired
    private VideoService videoService;
    @MockBean
    private MovieRepository movieRepository;

    private String token;

    @Before
    public void setUp() throws Exception {
        when(userService.loadUserByUsername(anyString())).thenReturn(buildUser());
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(getAuthentication());
        when(userService.registerUser(any(RegisterRequest.class))).thenReturn(buildUserResponse());
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .addFilter(jwtAuthenticationFilter)
                .build();
        token = "Bearer " + JsonPath.parse(this.mockMvc.perform(post("/login")
                .content(asJsonString(buildLoginRequest()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.jwt").isNotEmpty())
                .andReturn()
                .getResponse()
                .getContentAsString()).read("$.jwt");
        Movie movie1 = buildMovie(1L);
        Movie movie2 = buildMovie(2L);
        Opinion opinion = buildOpinion();
        movie1.getOpinions().add(opinion);
        List<Movie> moviesList = new ArrayList<>();
        moviesList.add(movie1);
        moviesList.add(movie2);
        when(movieService.getMovies()).thenReturn(moviesList);
        when(movieRepository.findAll()).thenReturn(moviesList);
        when(movieRepository.findById(any())).thenReturn(java.util.Optional.of(movie1));
        when(movieRepository.findById(1L)).thenReturn(java.util.Optional.of(movie1));
    }

    @Test
    public void getMovies_shouldReturnListWithMovies() throws Exception {
        this.mockMvc.perform(get("/movies")
                .header("Authorization", token)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].title").value(MOVIE_TEST_TITLE))
                .andExpect(jsonPath("$[0].description").value(MOVIE_TEST_DESCRIPTION))
                .andExpect(jsonPath("$[0].resourceUri").value(MOVIE_TEST_RESOURCE_URI))
                .andExpect(jsonPath("$[0].coverUri").value(MOVIE_TEST_COVER_URI))
                .andExpect(jsonPath("$[0].category").value(MOVIE_TEST_CATEGORY))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getMovieOpinions_shouldReturnOpinion() throws Exception {
        this.mockMvc.perform(get("/movies/1/opinions")
                .header("Authorization", token)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].comment").value(OPINION_COMMENT_TEST))
                .andExpect(jsonPath("$[0].user").isNotEmpty())
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getVideo_statusShouldBePartialContent() throws Exception {
        this.mockMvc.perform(get("/movies/videos/Sniper")
                .header("Authorization", token)
                .header("range", "bytes=50-100")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isPartialContent());
    }
}
