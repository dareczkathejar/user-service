package com.tftask.userservice.usercontroller;

import com.tftask.userservice.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.github.api.GitHubRepo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import javax.ws.rs.BadRequestException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private GlobalExceptionHandler globalExceptionHandler;

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String testController() {
        return "Hello";
    }

    @RequestMapping(value = "/endpoints", method = RequestMethod.GET)
    public @ResponseBody Object getAllSystemEndpoints() {
        return userService.getSystemEndpoints(requestMappingHandlerMapping);
    }

    @RequestMapping(value = "/user/repositories/{username}", method = RequestMethod.GET)
    public @ResponseBody List<GitHubRepo> getUserRepositories(@PathVariable ("username") String username) {
        return userService.getUserRepositories(username);
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public BadRequestException handleException() {
        throw new BadRequestException();
    }

}
