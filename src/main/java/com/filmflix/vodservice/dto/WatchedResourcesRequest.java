package com.filmflix.vodservice.dto;

import javax.validation.constraints.NotNull;

public class WatchedResourcesRequest {
    @NotNull
    private Long stopTimeInSeconds;

    @NotNull
    private boolean fullyWatched;

    @NotNull
    private Integer userId;

    private Integer movieId;

    private Integer episodeId;
}
