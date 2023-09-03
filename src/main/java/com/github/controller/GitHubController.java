package com.github.controller;
//import com.github.repositories.GitHubRepository;
//import com.github.services.GitHubService;
import com.github.entities.GitHub;
import com.github.services.GitHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/repositories")
public class GitHubController {

    @Autowired
    private GitHubService gitHubService;

    @PostMapping("/test-connection")
    public ResponseEntity<GitHub> testConnection(@RequestBody GitHub gitHub) {
        GitHub savedRepository = gitHubService.testAndSaveRepository(gitHub);
        return ResponseEntity.ok(savedRepository);
    }
}

