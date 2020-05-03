package com.filmflix.vodservice.db.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
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
