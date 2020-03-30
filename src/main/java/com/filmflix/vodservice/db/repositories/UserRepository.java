package com.filmflix.vodservice.db.repositories;

import com.filmflix.vodservice.db.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
