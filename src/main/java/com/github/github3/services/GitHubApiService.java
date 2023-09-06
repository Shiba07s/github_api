package com.github.github3.services;

import com.github.github3.controller.GitHubAPIController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
@Service
public class GitHubApiService {

//    @Autowired
//    private final RestTemplate restTemplate;
//
////    public GitHubAPIService(RestTemplate restTemplate) {
////        this.restTemplate = restTemplate;
////    }
//
//    public Repository fetchRepo(String owner, String repo) {
//        String url = "https://api.github.com/repos/" + owner + "/" + repo;
//        ResponseEntity<Repository> response = restTemplate.getForEntity(url, Repository.class);
//        return response.getBody();
//    }
    //GitHubAPIController gitHubAPIController = new GitHubAPIController();
    //List<Map> fileMetadataList = gitHubAPIController.getContents("Shiba07s", "github_api", "main");
    //GitHubAPIController gitHubAPI = new GitHubAPIController();
   // List<Map> fileMetadata = gitHubAPIController.getContentsRepo("Shiba07s", "github_api");
}
