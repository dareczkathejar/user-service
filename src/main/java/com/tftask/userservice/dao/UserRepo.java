package com.tftask.userservice.dao;

import org.springframework.social.github.api.GitHubRepo;

public class UserRepo extends GitHubRepo {

    private String username;

    public UserRepo() {
    }

    public UserRepo(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
