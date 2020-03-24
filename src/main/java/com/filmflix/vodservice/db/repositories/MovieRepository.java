package com.filmflix.vodservice.db.repositories;

import com.filmflix.vodservice.db.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
