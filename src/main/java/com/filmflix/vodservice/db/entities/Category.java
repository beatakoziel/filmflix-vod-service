package com.filmflix.vodservice.db.entities;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(nullable = false)
    private boolean visibility;
}
