package com.filmflix.vodservice.db.repositories;

import com.filmflix.vodservice.db.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
