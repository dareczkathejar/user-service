package com.tftask.userservice.userservice;

 import com.tftask.userservice.userservice.exception.InvalidUserNameException;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.social.github.api.GitHubRepo;
 import org.springframework.stereotype.Service;
 import org.springframework.web.client.RestTemplate;
 import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
 import java.util.Arrays;
 import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final String API_URL_BASE = "https://api.github.com/";

    @Autowired
    private RestTemplate restTemplate;

    public Object[] getSystemEndpoints(RequestMappingHandlerMapping requestMappingHandlerMapping) {
        return requestMappingHandlerMapping.getHandlerMethods().keySet().stream().map(t ->
                (t.getMethodsCondition().getMethods().size() == 0 ? "GET" : t.getMethodsCondition().getMethods().toArray()[0]) + " " +
                        t.getPatternsCondition().getPatterns().toArray()[0]
        ).toArray();
    }

    @Override
    public List<GitHubRepo> getUserRepositories(String username) {
        List<GitHubRepo> gitHubRepos = Arrays.asList(restTemplate.getForObject(buildUserUri("/repos"), GitHubRepo[].class, username));
        if (gitHubRepos.isEmpty()){
            throw new InvalidUserNameException(username);
        }
        return gitHubRepos;
    }

    private String buildUserUri(String path) {
        return buildUri("users/{user}" + path);
    }

    protected String buildUri(String path) {
            return API_URL_BASE + path;
        }


}

