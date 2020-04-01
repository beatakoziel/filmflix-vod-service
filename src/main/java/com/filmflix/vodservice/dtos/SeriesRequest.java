package com.filmflix.vodservice.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Year;

public class SeriesRequest {
    @NotNull
    @NotBlank
    private String title;

    @NotNull
    @NotBlank
    private String description;

    @NotNull
    @NotBlank
    private String coverUri;

    @NotNull
    @NotBlank
    private String cast;

    @NotNull
    @NotBlank
    private String directors;

    @NotNull
    private Year year;
}
