package com.tftask.userservice.userservice.converter;

import com.tftask.userservice.dao.UserRepo;
import com.tftask.userservice.dao.builder.UserRepoBuilder;
import org.springframework.social.github.api.GitHubRepo;
import org.springframework.stereotype.Component;

@Component
public class GitHubRepoToUserRepoConverter {

    public UserRepo convert(GitHubRepo gitHubRepo, String username){

        return new UserRepoBuilder(username, gitHubRepo.getId(), gitHubRepo.getName(), gitHubRepo.getDescription(), gitHubRepo.getUrl())
                .withCloneUrl(gitHubRepo.getCloneUrl())
                .withGitUrl(gitHubRepo.getGitUrl())
                .withHtmlUrl(gitHubRepo.getHtmlUrl())
                .withSshUrl(gitHubRepo.getSshUrl())
                .withSvnUrl(gitHubRepo.getSvnUrl())
                .build();
    }
}
