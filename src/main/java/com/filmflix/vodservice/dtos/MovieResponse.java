package com.filmflix.vodservice.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class MovieResponse {
    private String description;
    private String resourceUri;
    private String title;
}
