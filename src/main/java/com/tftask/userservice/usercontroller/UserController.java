package com.tftask.userservice.usercontroller;

import com.tftask.userservice.dao.UserRepo;
import com.tftask.userservice.userservice.UserService;
import com.tftask.userservice.usercontroller.exception.GlobalExceptionHandler;
import com.tftask.userservice.usercontroller.validator.UsernameValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private GlobalExceptionHandler globalExceptionHandler;

    @Autowired
    private UsernameValidator usernameValidator;

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/endpoints", method = RequestMethod.GET)
    public @ResponseBody Object getAllSystemEndpoints() {
        return userService.getSystemEndpoints(requestMappingHandlerMapping);
    }

    @RequestMapping(value = "/user/repositories", method = RequestMethod.GET)
    public List<UserRepo> getUserRepositories(@RequestParam(value = "username") String username) {
        usernameValidator.validateUsername(username);
        return userService.getUserRepositories(username);
    }

}
