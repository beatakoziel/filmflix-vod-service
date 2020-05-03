package com.filmflix.vodservice.db.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
