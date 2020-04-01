package com.filmflix.vodservice.dto;

import javax.validation.constraints.NotNull;

public class EpisodeRequest extends ResourceRequest {
    private long creditsStartTimeInSeconds;

    private int introStartTimeInSeconds;

    private int introStopTimeInSeconds;

    @NotNull
    private Integer episodeNumber;

    @NotNull
    private Integer seasonNumber;
}
