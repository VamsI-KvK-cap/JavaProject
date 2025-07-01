package com.example.cleanup;

public class SystemOptions {
    private boolean optionFlag1;
    private boolean optionFlag2;
    private String identifier;

    public SystemOptions(boolean optionFlag1, boolean optionFlag2, String identifier) {
        this.optionFlag1 = optionFlag1;
        this.optionFlag2 = optionFlag2;
        this.identifier = identifier;
    }

    public boolean isOptionFlag1() {
        return optionFlag1;
    }

    public void setOptionFlag1(boolean optionFlag1) {
        this.optionFlag1 = optionFlag1;
    }

    public boolean isOptionFlag2() {
        return optionFlag2;
    }

    public void setOptionFlag2(boolean optionFlag2) {
        this.optionFlag2 = optionFlag2;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public boolean validate() {
        return identifier != null && !identifier.isEmpty();
    }
}