package com.filmflix.vodservice.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class StreamingPlanRequest {
    @NotNull
    private BigDecimal price;

    @NotNull
    @NotBlank
    private String description;
}
