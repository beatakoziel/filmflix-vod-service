package com.filmflix.vodservice.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserRequest {
    @Email
    @NotNull
    @NotBlank
    private String email;

    @Email
    @NotNull
    @NotBlank
    private String password;

    @NotNull
    private Integer streamingPlanId;
}
