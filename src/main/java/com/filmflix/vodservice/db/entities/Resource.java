package com.filmflix.vodservice.db.entities;

import javax.persistence.*;

@MappedSuperclass
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String resourceUri;
}
