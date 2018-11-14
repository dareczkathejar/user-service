package com.tftask.userservice.dao;

import org.springframework.social.github.api.GitHubRepo;

public class UserRepo extends GitHubRepo {

    private String username;

    public UserRepo() {
    }

    public UserRepo(String username, Long id, String name, String description,
                     String url) {
        this.setUsername(username);
        this.setId(id);
        this.setName(name);
        this.setDescription(description);
        this.setUrl(url);
    }

    public UserRepo(String username, Long id, String name, String description,
                    String url, String cloneUrl, String gitUrl, String htmlIUrl,
                    String sshUrl, String svnUrl) {
        this.setUsername(username);
        this.setId(id);
        this.setName(name);
        this.setName(description);
        this.setDescription(description);
        this.setUrl(url);
        this.setCloneUrl(cloneUrl);
        this.setGitUrl(gitUrl);
        this.setHtmlUrl(htmlIUrl);
        this.setSshUrl(sshUrl);
        this.setSvnUrl(svnUrl);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
