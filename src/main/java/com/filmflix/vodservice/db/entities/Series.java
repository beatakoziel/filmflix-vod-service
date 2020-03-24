package com.filmflix.vodservice.db.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Series {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String coverUri;

    @Column(nullable = false)
    private String cast;

    @Column(nullable = false)
    private String directors;

    @Column(nullable = false)
    private int year;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Episode> episodes;
}
