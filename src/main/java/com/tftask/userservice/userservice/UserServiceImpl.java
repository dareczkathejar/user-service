package com.tftask.userservice.userservice;

 import com.tftask.userservice.dao.UserRepo;
 import com.tftask.userservice.dao.UserServiceEndpoint;
 import com.tftask.userservice.userservice.converter.GitHubRepoToUserRepoConverter;
 import com.tftask.userservice.userservice.exception.GitHubAccountNotFoundException;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.social.github.api.GitHubRepo;
 import org.springframework.stereotype.Service;
 import org.springframework.web.client.RestClientException;
 import org.springframework.web.client.RestTemplate;
 import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
 import java.util.Arrays;
 import java.util.List;
 import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static final String API_URL_BASE = "https://api.github.com/";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private GitHubRepoToUserRepoConverter gitHubRepoToUserRepoConverter;

    public List<UserServiceEndpoint> getSystemEndpoints(RequestMappingHandlerMapping requestMappingHandlerMapping) {
        return requestMappingHandlerMapping.getHandlerMethods().keySet().stream().map(
                t -> new UserServiceEndpoint(t.getMethodsCondition().toString(), t.getPatternsCondition().toString()))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserRepo> getUserRepositories(String username) {
        try {
            List<GitHubRepo> gitHubRepos = Arrays.asList(restTemplate.getForObject(buildUserUri("/repos"), GitHubRepo[].class, username));
            return gitHubRepos.stream()
                    .map(repo -> gitHubRepoToUserRepoConverter.convert(repo, username))
                    .collect(Collectors.toList());
        } catch (RestClientException e){
            throw new GitHubAccountNotFoundException(username);
        }
    }

    private String buildUserUri(String path) {
        return buildUri("users/{user}" + path);
    }

    private String buildUri(String path) {
            return API_URL_BASE + path;
    }


}

