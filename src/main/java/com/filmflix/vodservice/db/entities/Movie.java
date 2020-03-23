package com.filmflix.vodservice.db.entities;

import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Builder
public class Movie extends Resource {
    @Column(nullable = false)
    private String coverUri;

    @Column(nullable = false)
    private long totalTimeInMinutes;

    @Column(nullable = false)
    private String cast;

    @Column(nullable = false)
    private String directors;

    @Column(nullable = false)
    private int year;
}
