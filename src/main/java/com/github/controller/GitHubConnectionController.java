package com.github.controller;

import com.github.entities.GitHubConnectionRequest;
import com.github.services.GitHubConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/github")
public class GitHubConnectionController {

    @Autowired
    private GitHubConnectionService gitHubConnectionService;

    @PostMapping("/test-connection")
    public ResponseEntity<String> testGitHubConnection(@RequestBody GitHubConnectionRequest request) {
        boolean isConnected = gitHubConnectionService.testGitHubConnection(request);

        if (isConnected) {
            return ResponseEntity.ok("GitHub connection is successful!");
        } else {
            return ResponseEntity.badRequest().body("connection failed");
           // return ResponseEntity.badRequest().body("GitHub connection failed. Please check your inputs.");
        }
    }
}
