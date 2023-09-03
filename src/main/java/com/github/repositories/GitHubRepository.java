package com.github.repositories;

import com.github.entities.GitHub;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GitHubRepository extends JpaRepository<GitHub, Long> {
}
