package org.epam.training;


import java.util.Map;


public class Client {
    private String address;
    private Map<String, String> userInputKeyValue;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Map<String, String> getUserInputKeyValue() {
        return userInputKeyValue;
    }

    public void setUserInputKeyValue(Map<String, String> userInputKeyValue) {
        this.userInputKeyValue = userInputKeyValue;
    }
}
