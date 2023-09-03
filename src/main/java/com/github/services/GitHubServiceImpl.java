package com.github.services;


import com.github.entities.GitHub;
import com.github.repositories.GitHubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GitHubServiceImpl implements GitHubService {
    @Autowired
    private GitHubRepository githubRepo;

    @Override
    public GitHub testAndSaveRepository(GitHub gitHub) {
        // Implement the logic to test the GitHub connection here
        // You can use libraries like JGit or GitHub API to test the connection

        // If the connection test fails, set connectionTested to false and handle exceptions
        // If successful, set connectionTested to true

        try {
            // Test GitHub connection logic here

            // If successful:
            gitHub.setConnectionTested(true);
            return githubRepo.save(gitHub);

        } catch (Exception e) {
            // Handle exceptions and store error status
            gitHub.setConnectionTested(false);
            return githubRepo.save(gitHub);
        }
    }

}
