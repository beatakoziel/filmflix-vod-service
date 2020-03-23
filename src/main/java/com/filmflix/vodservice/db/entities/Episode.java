package com.filmflix.vodservice.db.entities;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Builder
public class Episode extends Resource {
    @Column(nullable = false)
    private long creditsStartTimeInSeconds;

    @Column(nullable = false)
    private int introStartTimeInSeconds;

    @Column(nullable = false)
    private int introStopTimeInSeconds;

    @Column(nullable = false)
    private int episodeNumber;

    @Column(nullable = false)
    private int seasonNumber;
}
