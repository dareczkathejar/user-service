package com.tftask.userservice.userservice;
import com.tftask.userservice.dao.UserRepo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;

public interface UserService {

    Object getSystemEndpoints(RequestMappingHandlerMapping requestMappingHandlerMapping);

    List<UserRepo> getUserRepositories(String username);
}
