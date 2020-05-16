package com.filmflix.vodservice.utilities;

import com.filmflix.vodservice.db.entities.Movie;
import com.filmflix.vodservice.db.entities.Opinion;

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
                .comment(COMMENT_TEST)
                .build();
    }
}
