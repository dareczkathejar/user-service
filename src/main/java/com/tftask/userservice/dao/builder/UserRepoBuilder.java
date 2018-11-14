package com.tftask.userservice.dao.builder;

import com.tftask.userservice.dao.UserRepo;

public class UserRepoBuilder {

    private String username;

    private Long id;

    private String name;

    private String description;

    private String url;

    private String cloneUrl;

    private String gitUrl;

    private String htmlIUrl;

    private String sshUrl;

    private String svnUrl;


    public UserRepoBuilder(final String username, final Long id, final String name, final String description,
                           final String url) {
        this.username = username;
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
    }
    public UserRepoBuilder(final String username, final Long id, final String name, final String description,
                           final String url, final String cloneUrl, final String gitUrl, final String htmlIUrl,
                           final String sshUrl, final String svnUrl) {
        this.username = username;
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.cloneUrl = cloneUrl;
        this.gitUrl = gitUrl;
        this.htmlIUrl = htmlIUrl;
        this.sshUrl = sshUrl;
        this.svnUrl = svnUrl;
    }

    public UserRepo buildFull(){
        UserRepo userRepo = new UserRepo(username, id,  name,  description, url, cloneUrl, gitUrl, htmlIUrl, sshUrl, svnUrl);
        return userRepo;
    }

    public UserRepo build(){
        UserRepo userRepo = new UserRepo(username, id,  name,  description, url);
        return userRepo;
    }

    public UserRepoBuilder withCloneUrl(final String cloneUrl){
        this.cloneUrl = cloneUrl;
        return this;
    }

    public UserRepoBuilder withGitUrl(final String gitUrl){
        this.gitUrl = gitUrl;
        return this;
    }
    public UserRepoBuilder withHtmlUrl(final String htmlIUrl){
        this.htmlIUrl = htmlIUrl;
        return this;
    }
    public UserRepoBuilder withSshUrl(final String sshUrl){
        this.sshUrl = sshUrl;
        return this;
    }
    public UserRepoBuilder withSvnUrl(final String svnUrl){
        this.svnUrl = svnUrl;
        return this;
    }

}
