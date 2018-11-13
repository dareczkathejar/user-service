package com.tftask.userservice.usercontroller.validator;

import com.tftask.userservice.userservice.exception.MissingParameterException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UsernameValidator {

    public void validateUsername(String username){
        if (Objects.isNull(username) || username.isEmpty()){
            throw new MissingParameterException(username);
        }
    }
}
