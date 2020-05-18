package com.filmflix.vodservice.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.filmflix.vodservice.db.entities.Movie;
import com.filmflix.vodservice.db.entities.Opinion;
import com.filmflix.vodservice.db.entities.User;
import com.filmflix.vodservice.db.enums.UserRole;
import com.filmflix.vodservice.dtos.requests.LoginRequest;
import com.filmflix.vodservice.dtos.requests.RegisterRequest;
import com.filmflix.vodservice.dtos.responses.UserResponse;

import java.util.ArrayList;

import static com.filmflix.vodservice.utilities.TestConstants.*;

public class TestBuilders {

    public static Movie buildMovie(Long id) {
        return Movie.builder()
                .id(id)
                .category(MOVIE_TEST_CATEGORY)
                .title(MOVIE_TEST_TITLE)
                .description(MOVIE_TEST_DESCRIPTION)
                .resourceUri(MOVIE_TEST_RESOURCE_URI)
                .coverUri(MOVIE_TEST_COVER_URI)
                .opinions(new ArrayList<>())
                .build();
    }

    public static Opinion buildOpinion() {
        return Opinion.builder()
                .id(1L)
                .comment(OPINION_COMMENT_TEST)
                .build();
    }

    public static User buildUser() {
        return User.builder()
                .id(1L)
                .email(USER_TEST_EMAIL)
                .password(USER_TEST_PASSWORD)
                .role(UserRole.USER)
                .planPaid(false)
                .blocked(false)
                .build();
    }

    public static RegisterRequest buildRegisterRequest(String username, String password) {
        return RegisterRequest.builder()
                .username(username)
                .password(USER_TEST_PASSWORD)
                .repeatPassword(password)
                .build();
    }

    public static UserResponse buildUserResponse(){
        return UserResponse.builder()
                .email(USER_TEST_EMAIL)
                .planPaid(false)
                .build();
    }

    public static LoginRequest buildLoginRequest(){
        return LoginRequest.builder()
                .username(USER_TEST_EMAIL)
                .password(USER_TEST_PASSWORD)
                .build();
    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
