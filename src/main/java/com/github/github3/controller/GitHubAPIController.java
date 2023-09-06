package com.github.github3.controller;

import com.github.github3.services.GitHubApiService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fetch-repo")
public class GitHubAPIController {
        private final String gitHubApiBaseUrl = "https://api.github.com/repos/";

        @GetMapping("/{owner}/{repo}")
        public ResponseEntity<String> fetchRepository(
                @PathVariable("owner") String owner,
                @PathVariable("repo") String repo) {

            try {
                // You can configure RestTemplate to use Bearer token authentication here
                RestTemplate restTemplate = new RestTemplate();
                String accessToken = "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"; // Replace with your GitHub access token
                String apiUrl = gitHubApiBaseUrl + owner + "/" + repo;

                ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
                return response;
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching repository data.");
            }
        }

    @GetMapping("/repos/{owner}/{repo}/contents/{branch}")
    public List<Map> getContents(@PathVariable String owner, @PathVariable String repo, @PathVariable String branch) {

        // Create a REST template.
        RestTemplate restTemplate = new RestTemplate();

        // Call the GitHub REST API.
        List<Map> response = restTemplate.getForObject(
                "https://api.github.com/repos/{owner}/{repo}/contents?ref={branch}", List.class, owner, repo, branch);

        return response;
    }

//        @GetMapping("{/repos/{owner}/{repo}/contents/{branch}")
//    public List<Map> getContents(@PathVariable String owner, @PathVariable String repo, @PathVariable String branch) {
//
//        // Create a REST template.
//        RestTemplate restTemplate = new RestTemplate();
//
//        // Call the GitHub REST API.
//        List<Map> response = restTemplate.getForObject(
//                "https://api.github.com/repos/{owner}/{repo}/contents?ref={branch}", List.class, owner, repo, branch);
//
//        return response;
//    }



//     @Autowired
//     private GitHubApiService gitHubApiService;
//
//    @GetMapping("/repos/{owner}/{repo}")
//    public List<Map> getContents(@PathVariable String owner, @PathVariable String repo ) {
//
//        // Create a REST template.
//        RestTemplate restTemplate = new RestTemplate();
//
//        // Call the GitHub REST API.
//        List<Map> response = restTemplate.getForObject(
//                "https://api.github.com/repos/{owner}/{repo} ", List.class, owner, repo);
//
//        return response;
//    }



//    @GetMapping("/repos/{owner}/{repo}/contents/{branch}")
//    public List<Map> getContents(@PathVariable String owner, @PathVariable String repo, @PathVariable String branch) {
//
//        // Create a REST template.
//        RestTemplate restTemplate = new RestTemplate();
//
//        // Call the GitHub REST API.
//        List<Map> response = restTemplate.getForObject(
//                "https://api.github.com/repos/{owner}/{repo}/contents?ref={branch}", List.class, owner, repo, branch);
//
//        return response;
//    }
//    @GetMapping("/fetch-repo/{owner}/{repo}")
//    public Repository fetchRepo(@PathVariable String owner, @PathVariable String repo) {
//        return gitHubAPIService.fetchRepo(owner, repo);
//    }
//    @GetMapping("/repos/{owner}/{repo}")
//    public List<Map> getContentsRepo(@PathVariable String owner, @PathVariable String repo) {
//
//        // Create a REST template.
//        RestTemplate restTemplate = new RestTemplate();
//
//        // Call the GitHub REST API.
//        List<Map> authorize = restTemplate.getForObject(
//                "https://api.github.com/repos/{owner}/{repo}", List.class, owner, repo);
//
//        return authorize;
//    }
}
