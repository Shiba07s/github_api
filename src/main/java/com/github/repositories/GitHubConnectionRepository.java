package com.github.repositories;

import com.github.entities.GitHubConnectionRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GitHubConnectionRepository extends JpaRepository<GitHubConnectionRequest, Long> {

    void setConnectionSuccessful(boolean b);
}
