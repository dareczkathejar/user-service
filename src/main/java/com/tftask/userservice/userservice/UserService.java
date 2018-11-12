package com.tftask.userservice.userservice;

import org.springframework.social.github.api.GitHubRepo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;

public interface UserService {

    Object getSystemEndpoints(RequestMappingHandlerMapping requestMappingHandlerMapping);

    List<GitHubRepo> getUserRepositories(String username);
}
