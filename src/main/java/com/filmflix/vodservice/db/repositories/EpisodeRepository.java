package com.filmflix.vodservice.db.repositories;

import com.filmflix.vodservice.db.entities.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {
}
