package com.filmflix.vodservice.db.repositories;

import com.filmflix.vodservice.db.entities.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OpinionRepository extends JpaRepository<Opinion, Long> {
}
