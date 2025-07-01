package com.example.systemoptions;

public class SystemOptions {
    private String option1;
    private int option2;
    private boolean option3;

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        if (option1 != null && !option1.isEmpty()) {
            this.option1 = option1;
        } else {
            throw new IllegalArgumentException("Invalid value for option1");
        }
    }

    public int getOption2() {
        return option2;
    }

    public void setOption2(int option2) {
        if (option2 >= 0) {
            this.option2 = option2;
        } else {
            throw new IllegalArgumentException("Invalid value for option2");
        }
    }

    public boolean isOption3() {
        return option3;
    }

    public void setOption3(boolean option3) {
        this.option3 = option3;
    }

    public void initializeOptions(String option1, int option2, boolean option3) {
        setOption1(option1);
        setOption2(option2);
        setOption3(option3);
    }

    public void validateOptions() {
        if (option1 == null || option1.isEmpty()) {
            throw new IllegalStateException("option1 must be set");
        }
        if (option2 < 0) {
            throw new IllegalStateException("option2 must be non-negative");
        }
    }
}