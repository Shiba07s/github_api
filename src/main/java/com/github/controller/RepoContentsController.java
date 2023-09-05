package com.github.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.entities.RepoFileMetadata;
import com.github.services.RepoContentsService;

@RestController
@RequestMapping("/api/")
public class RepoContentsController {
	 @Autowired
	    private RepoContentsService repoContentsService;

	    @GetMapping("/repos/{username}/{repoName}/{branch}")
	    public List<RepoFileMetadata> getRepoContents(@PathVariable String username, @PathVariable String repoName, @PathVariable String branch) {
	        return repoContentsService.getRepoContents(username, repoName, branch);
	    }

}
