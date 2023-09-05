package com.github.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.entities.RepoFile;
import com.github.entities.RepoFileMetadata;
import com.github.model.GitHubClient;

@Service
public class RepoContentsService {
	
	private final GitHubClient gitHubClient;

    public RepoContentsService(GitHubClient gitHubClient) {
        this.gitHubClient = gitHubClient;
    }

    public List<RepoFileMetadata> getRepoContents(String username, String repoName, String branch) {
        // Get the contents of the repo from the GitHub API.
        List<RepoFile> repoFiles = gitHubClient.getRepoContents(username, repoName, branch);

        // Convert the repo files to a list of file metadata.
        List<RepoFileMetadata> fileMetadataList = new ArrayList<>();
        for (RepoFile repoFile : repoFiles) {
            fileMetadataList.add(new RepoFileMetadata(repoFile.getName(), repoFile.getDownloadUrl()));
        }

        return fileMetadataList;
    }

}
