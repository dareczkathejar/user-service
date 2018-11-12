package com.tftask.userservice.userservice.exception;

import javax.ws.rs.NotFoundException;

public class InvalidUserNameException extends NotFoundException {

    private static String MESSAGE = "User with username =%s not found. Please provide an existing username.";

    public InvalidUserNameException(String username) {
        super(String.format(MESSAGE, username));
    }
}
