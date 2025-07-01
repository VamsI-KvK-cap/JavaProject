package com.example.systemoptions;

import java.util.regex.Pattern;

public class SystemOptions {
    private String optionFlag;
    private String optionValue;
    private String optionDescription;
    private int optionPriority;

    public String getOptionFlag() {
        return optionFlag;
    }

    public void setOptionFlag(String optionFlag) {
        this.optionFlag = optionFlag;
    }

    public String getOptionValue() {
        return optionValue;
    }

    public void setOptionValue(String optionValue) {
        this.optionValue = optionValue;
    }

    public String getOptionDescription() {
        return optionDescription;
    }

    public void setOptionDescription(String optionDescription) {
        this.optionDescription = optionDescription;
    }

    public int getOptionPriority() {
        return optionPriority;
    }

    public void setOptionPriority(int optionPriority) {
        this.optionPriority = optionPriority;
    }

    public boolean validate() {
        return optionFlag != null && !optionFlag.isEmpty() &&
               optionValue != null && !optionValue.isEmpty() &&
               isValidDescription(optionDescription) &&
               isValidPriority(optionPriority);
    }

    private boolean isValidDescription(String description) {
        return description != null && !description.isEmpty();
    }

    private boolean isValidPriority(int priority) {
        return priority >= 0;
    }
}