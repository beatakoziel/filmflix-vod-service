package com.filmflix.vodservice.db.repositories;

import com.filmflix.vodservice.db.entities.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesRepository extends JpaRepository<Series, Long> {
}
