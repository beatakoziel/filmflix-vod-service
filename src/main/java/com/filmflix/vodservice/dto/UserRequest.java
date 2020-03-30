package com.filmflix.vodservice.dto;

import com.filmflix.vodservice.db.enums.UserRole;

import javax.persistence.*;
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
