package com.filmflix.vodservice.dtos.requests;

import javax.validation.constraints.NotNull;

public class OpinionRequest {
    private String comment;

    @NotNull
    private Byte starsNumber;

    @NotNull
    private Long userId;
}
