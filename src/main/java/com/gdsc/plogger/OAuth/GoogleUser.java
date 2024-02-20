package com.gdsc.plogger.OAuth;

import java.util.Map;

public class GoogleUser {
    private Map<String, Object> attribute;

    public GoogleUser(Map<String, Object> attribute) {
        this.attribute = attribute;
    }

    public String getEmail() {
        return (String) attribute.get("email");
    }

    public String getName() {
        return (String) attribute.get("fullName");
    }
}
