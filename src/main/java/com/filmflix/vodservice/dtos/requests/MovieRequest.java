package com.filmflix.vodservice.dtos.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Year;
import java.util.List;

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

    @NotNull
    private Integer categoryId;

    @NotEmpty
    private List<Integer> tagsIds;
}
