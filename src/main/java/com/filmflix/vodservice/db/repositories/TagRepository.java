package com.filmflix.vodservice.db.repositories;

import com.filmflix.vodservice.db.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
