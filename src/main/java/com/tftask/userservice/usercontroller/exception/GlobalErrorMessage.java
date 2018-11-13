package com.tftask.userservice.usercontroller.exception;

import java.util.List;
import java.util.Map;

public class GlobalErrorMessage {

    private String title;

    private String type;

    private Map<String, Object> properties;

    private List<String> required;

    public GlobalErrorMessage(String title, String type, Map<String, Object> properties, List<String> required) {
        this.title = title;
        this.type = type;
        this.properties = properties;
        this.required = required;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    public List<String> getRequired() {
        return required;
    }

    public void setRequired(List<String> required) {
        this.required = required;
    }
}
