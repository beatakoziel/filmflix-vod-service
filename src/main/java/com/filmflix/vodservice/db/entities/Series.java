package com.filmflix.vodservice.db.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
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

    @ManyToOne
    private Category category;

    @ManyToMany
    private List<Tag> tags;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Episode> episodes;
}
