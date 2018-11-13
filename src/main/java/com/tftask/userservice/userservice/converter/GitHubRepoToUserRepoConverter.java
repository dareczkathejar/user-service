package com.tftask.userservice.userservice.converter;

import com.tftask.userservice.dao.UserRepo;
import org.springframework.social.github.api.GitHubRepo;
import org.springframework.stereotype.Component;

@Component
public class GitHubRepoToUserRepoConverter {

    public UserRepo convert(GitHubRepo gitHubRepo, String username){
        UserRepo userRepo = new UserRepo(username);
        userRepo.setName(gitHubRepo.getName());
        userRepo.setCloneUrl(gitHubRepo.getCloneUrl());
        userRepo.setDescription(gitHubRepo.getDescription());
        userRepo.setGitUrl(gitHubRepo.getGitUrl());
        userRepo.setHtmlUrl(gitHubRepo.getHtmlUrl());
        userRepo.setId(gitHubRepo.getId());
        userRepo.setSshUrl(gitHubRepo.getSshUrl());
        userRepo.setSvnUrl(gitHubRepo.getSvnUrl());
        userRepo.setUrl(gitHubRepo.getUrl());

        return userRepo;
    }
}
