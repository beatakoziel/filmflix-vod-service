package com.filmflix.vodservice.db.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Opinion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    /*@Column(nullable = false)
    private byte starsNumber;*/

    @ManyToOne
    private User user;
}
