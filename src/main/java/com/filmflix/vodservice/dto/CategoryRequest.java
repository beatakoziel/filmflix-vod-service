package com.filmflix.vodservice.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CategoryRequest {
    @NotNull
    @NotBlank
    private String name;
}
