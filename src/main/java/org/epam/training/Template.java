package org.epam.training;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Template {
    private String body;
    private Map<String, String> keyValuePairs;

    public Template() {
        this.body = "";
        this.keyValuePairs = new HashMap<>();
    }

    private void populateKeysInKeyValuePairs() {
        List<String> keys = obtainKeysFromBody();
        keys.forEach(k -> keyValuePairs.put(k, null));
    }

    private List<String> obtainKeysFromBody() {
        List<String> keys = new ArrayList<>();
        StringBuilder key = new StringBuilder();
        int index = 0;
        while (index < body.length() ) {
            if (index < body.length() - 3 && body.charAt(index) == '#') {
                index += 2;
                while (index < body.length() && body.charAt(index) != '}') {
                    key.append(body.charAt(index++));
                }
                if (index < body.length() && body.charAt(index) == '}') {
                    keys.add(key.toString());
                    key = new StringBuilder();
                }
            } else {
                index++;
            }
        }
        return keys;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
        this.keyValuePairs = new HashMap<>();
        populateKeysInKeyValuePairs();
    }

    public Map<String, String> getKeyValuePairs() {
        return keyValuePairs;
    }

    public void setKeyValuePairs(Map<String, String> keyValuePairs) {
        this.keyValuePairs = keyValuePairs;
    }
}
