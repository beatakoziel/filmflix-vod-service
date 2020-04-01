package com.filmflix.vodservice.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ResourceRequest {
    @NotNull
    @NotBlank
    private String title;

    @NotNull
    @NotBlank
    private String description;

    @NotNull
    @NotBlank
    private String resourceUri;

}
