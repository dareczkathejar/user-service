package com.tftask.userservice.dao;

public class UserServiceEndpoint {

    private String requestMethod;

    private String uriPath;

    private String outputType;

    public UserServiceEndpoint() {
    }

    public UserServiceEndpoint(String requestMethod, String uriPath) {
        this.requestMethod = requestMethod;
        this.uriPath = uriPath;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getUriPath() {
        return uriPath;
    }

    public void setUriPath(String uriPath) {
        this.uriPath = uriPath;
    }
}




