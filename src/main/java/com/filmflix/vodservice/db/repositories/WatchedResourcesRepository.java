package com.filmflix.vodservice.db.repositories;

import com.filmflix.vodservice.db.entities.WatchedResources;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchedResourcesRepository extends JpaRepository<WatchedResources, Long> {
}
