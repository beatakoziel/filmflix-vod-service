package com.filmflix.vodservice.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Year;

public class MovieRequest extends ResourceRequest {
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
