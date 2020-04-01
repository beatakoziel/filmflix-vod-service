package com.filmflix.vodservice.db.entities;

import lombok.Builder;

import javax.persistence.*;

@Entity
@Builder
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;
}
