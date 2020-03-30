package com.filmflix.vodservice.db.entities;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Builder
public class WatchedResources {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long stopTimeInSeconds;

    @Column(nullable = false)
    private boolean fullyWatched;

    @ManyToOne
    private User user;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Episode episode;
}
