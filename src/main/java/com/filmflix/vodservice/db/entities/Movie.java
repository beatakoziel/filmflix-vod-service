package com.filmflix.vodservice.db.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
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
    private String coverUri;

/*    @Column(nullable = false)
    private long totalTimeInMinutes;

    @Column(nullable = false)
    private String cast;

    @Column(nullable = false)
    private String directors;

    @Column(nullable = false)
    private int year;*/

    @Column(nullable = false)
    private String category;

/*    @ManyToMany
    private List<Tag> tags;*/
}
