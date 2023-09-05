package com.github;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.model.GitHubClient;

@SpringBootApplication
public class Github5Application {

	public static void main(String[] args) {
		SpringApplication.run(Github5Application.class, args);
	}
	 @Bean
	    public GitHubClient gitHubClient() {
	        // Configure and create your GitHubClient instance here
	        return new GitHubClient(/* configure as needed */);
	    }

}
