package com.tftask.userservice.userservice.exception;

import javax.ws.rs.NotFoundException;

public class GitHubAccountNotFoundException extends NotFoundException {

    private static String MESSAGE = "No gitHub account found for username =%s.";

    public GitHubAccountNotFoundException(String username) {
        super(String.format(MESSAGE, username));
    }
}
