package com.example.processing;

import java.util.HashMap;
import java.util.Map;

public class ReclaimMaster {
    private String chp20ReclaimMaster;
    private Map<String, String> userSpecificValues;

    public ReclaimMaster() {
        this.userSpecificValues = new HashMap<>();
    }

    public void initialize(String chp20ReclaimMaster) {
        if (chp20ReclaimMaster == null || chp20ReclaimMaster.isEmpty()) {
            throw new IllegalArgumentException("chp20ReclaimMaster cannot be null or empty");
        }
        this.chp20ReclaimMaster = chp20ReclaimMaster;
    }

    public boolean validate() {
        return chp20ReclaimMaster != null && !chp20ReclaimMaster.isEmpty() && validateUserSpecificValues();
    }

    private boolean validateUserSpecificValues() {
        for (String value : userSpecificValues.values()) {
            if (value == null || value.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public void setUserSpecificValue(String key, String value) {
        if (key == null || key.isEmpty()) {
            throw new IllegalArgumentException("Key cannot be null or empty");
        }
        if (value != null && !value.isEmpty()) {
            userSpecificValues.put(key, value);
        }
    }

    public String getUserSpecificValue(String key) {
        return userSpecificValues.get(key);
    }

    public void removeUserSpecificValue(String key) {
        userSpecificValues.remove(key);
    }

    public String getChp20ReclaimMaster() {
        return chp20ReclaimMaster;
    }
}