package com.tftask.userservice.userservice;
import com.tftask.userservice.dao.UserRepo;
import com.tftask.userservice.dao.UserServiceEndpoint;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;

public interface UserService {

    List<UserServiceEndpoint> getSystemEndpoints(RequestMappingHandlerMapping requestMappingHandlerMapping);

    List<UserRepo> getUserRepositories(String username);
}
