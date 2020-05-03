package com.filmflix.vodservice.db.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String resourceUri;

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
