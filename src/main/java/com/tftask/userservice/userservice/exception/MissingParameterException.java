package com.tftask.userservice.userservice.exception;
import javax.ws.rs.NotFoundException;

public class MissingParameterException extends NotFoundException {

    private static String MESSAGE = "Missing request parameter =%s.";

    public MissingParameterException(String username) {
        super(String.format(MESSAGE, username));
    }

    public static String getMESSAGE() {
        return MESSAGE;
    }
}
