package com.github.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="github_ld")
public class GitHub{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String repositoryName;
    private String username;
    private String branch;
    private String repositoryUrl;
    private boolean connectionTested;
    // getters and setters
}
