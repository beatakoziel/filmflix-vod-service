package com.filmflix.vodservice.db.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
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

    @ManyToOne
    private Category category;

    @ManyToMany
    private List<Tag> tags;
}
