package com.github.services;

import com.github.entities.GitHubConnectionRequest;
import com.github.repositories.GitHubConnectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GitHubConnectionService {

    @Autowired
    private GitHubConnectionRepository githubRepository;

    public boolean testGitHubConnection(GitHubConnectionRequest request) {
        String username = request.getUsername();
        String repoName = request.getRepoName();
        String branch = request.getBranch();
        String repositoryUrl = request.getRepositoryUrl();

        String apiUrl = "https://api.github.com/repos/" + username + "/" + repoName + "/branches/" + branch;

        // Set up RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        // Create URI with query parameters (for authentication if needed)
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiUrl);

        // Optionally, if you need to authenticate with a personal access token:
        // builder.queryParam("access_token", "your-access-token");

        ResponseEntity<String> response = restTemplate.getForEntity(builder.toUriString(), String.class);


        // Check the response status code
        if (response.getStatusCode() == HttpStatus.OK) {
            // The repository and branch exist, the connection is successful
            return true;
        } else {
            // The repository or branch doesn't exist, connection failed
            return false;
        }
        public GitHubConnectionRequest testGitHubConnection(GitHubConnectionRequest connection){
            String githubApiUrl = "https://api.github.com/repos/" + GitHubConnectionRequest.getUsername() + "/" + GitHubConnectionRequest.getRepoName() + "/branches/" + githubRepository.getBranch();

            try {
                ResponseEntity<String> response = restTemplate.getForEntity(githubApiUrl, String.class);

                if (response.getStatusCode() == HttpStatus.OK) {
                    githubRepository.setConnectionSuccessful(true);
                } else {
                    githubRepository.setConnectionSuccessful(false);
                }
            } catch (RestClientException e) {
                githubRepository.setConnectionSuccessful(false);
            }

            return connection.save(githubRepository);
        }
    }
}