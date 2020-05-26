/*
package com.filmflix.vodservice.controllers;

import com.filmflix.vodservice.configurations.security.jwt.JwtAuthenticationFilter;
import com.filmflix.vodservice.configurations.security.jwt.JwtUtil;
import com.filmflix.vodservice.db.repositories.UserRepository;
import com.filmflix.vodservice.services.UserService;
import com.filmflix.vodservice.utilities.mappers.UserMapper;
import com.jayway.jsonpath.JsonPath;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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

import static com.filmflix.vodservice.utilities.TestBuilders.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private WebApplicationContext context;
    @Autowired
    private AuthController authController;
    @Autowired
    private JwtUtil jwtUtil;

    private String token;

    @Before
    public void setUp() throws Exception {
        when(userRepository.findByEmail(anyString()))
                .thenReturn(java.util.Optional.ofNullable(buildUser()));
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class)))
                .thenReturn(getAuthentication());
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .addFilter(new JwtAuthenticationFilter())
                .build();
        token = "Bearer " + JsonPath.parse(this.mockMvc.perform(post("/login")
                .content(asJsonString(buildLoginRequest()))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.jwt").isNotEmpty())
                .andReturn()
                .getResponse()
                .getContentAsString()).read("$.jwt");
    }

    @Test
    public void shouldGetUserData() throws Exception {
        this.mockMvc.perform(get("/user")
                .header("Authorization", token)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
*/
