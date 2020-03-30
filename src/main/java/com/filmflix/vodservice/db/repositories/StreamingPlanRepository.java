package com.filmflix.vodservice.db.repositories;

import com.filmflix.vodservice.db.entities.StreamingPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamingPlanRepository extends JpaRepository<StreamingPlan, Long> {
}
