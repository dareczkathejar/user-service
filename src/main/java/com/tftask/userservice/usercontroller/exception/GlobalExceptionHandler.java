package com.tftask.userservice.usercontroller.exception;
import com.tftask.userservice.userservice.exception.ErrorCodes;
import com.tftask.userservice.userservice.exception.MissingParameterException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.NotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(MissingParameterException.class)
        @ResponseStatus(value = HttpStatus.BAD_REQUEST)
        @ResponseBody
        public GlobalErrorMessage handleBadRequestException(Exception e) {
            Map<String, Object> properties = new HashMap<>();
            properties.put("errorCode", ErrorCodes.REQUEST_PARAMETER_ERROR.name());
            properties.put("errorMessage", e.getMessage());
            return new GlobalErrorMessage(
                    HttpStatus.BAD_REQUEST.name(),
                    e.getClass().getSimpleName(),
                    properties,
                    properties.keySet().stream()
                            .collect(Collectors.toList()));
        }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public GlobalErrorMessage handleNotFoundException(Exception e) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("errorCode", ErrorCodes.USER_NOT_FOUND_ERROR.name());
        properties.put("errorMessage", e.getMessage());
        return new GlobalErrorMessage(
                HttpStatus.NOT_FOUND.name(),
                e.getClass().getSimpleName(),
                properties,
                properties.keySet().stream()
                        .collect(Collectors.toList()));
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public GlobalErrorMessage handleException(Exception e) {
        Map<String, Object> properties = new HashMap<>();
        properties.put("errorCode", ErrorCodes.INTERNAL_SERVER_ERROR.name());
        properties.put("errorMessage", e.getMessage());
        return new GlobalErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.name(),
                e.getClass().getSimpleName(),
                properties,
                properties.keySet().stream()
                        .collect(Collectors.toList()));
    }
}