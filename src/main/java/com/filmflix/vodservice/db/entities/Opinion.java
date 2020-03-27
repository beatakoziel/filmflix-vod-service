package com.filmflix.vodservice.db.entities;

import javax.persistence.*;

@Entity
public class Opinion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    @Column(nullable = false)
    private byte starsNumber;

    @ManyToOne
    private User user;
}
