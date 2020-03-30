package com.filmflix.vodservice.db.entities;

import com.filmflix.vodservice.db.enums.UserRole;

import javax.persistence.*;

@Entity
@Table(name = "filmflix_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean blocked = false;

    @Column(nullable = false)
    private boolean planPaid;

    @Column(nullable = false)
    private UserRole role;

    @ManyToOne
    private StreamingPlan streamingPlan;
}
