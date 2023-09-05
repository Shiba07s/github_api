package com.github.model;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.github.entities.RepoFile;

public class GitHubClient {
	 private final RestTemplate restTemplate;

	    public GitHubClient() {
	        this.restTemplate = new RestTemplate();
	    }

	    public List<RepoFile> getRepoContents(String username, String repoName, String branch) {
	        // Create a GET request to the GitHub API.
	        String requestUrl = "https://api.github.com/repos/" + username + "/" + repoName + "/contents?ref=" + branch;

	        // Execute the request and get the response.
	        ResponseEntity<List<RepoFile>> responseEntity = restTemplate.exchange(requestUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<RepoFile>>() {});

	        // Check the status code of the response.
	        int statusCode = responseEntity.getStatusCodeValue();
	        if (statusCode != 200) {
	            throw new RuntimeException("Get contents failed: " + statusCode);
	        }

	        // Get the list of repo files from the response body.
	        List<RepoFile> repoFiles = responseEntity.getBody();

	        return repoFiles;
	    }

}
