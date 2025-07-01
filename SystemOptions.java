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
        }
    }

    public int getOption2() {
        return option2;
    }

    public void setOption2(int option2) {
        if (option2 >= 0) {
            this.option2 = option2;
        }
    }

    public boolean isOption3() {
        return option3;
    }

    public void setOption3(boolean option3) {
        this.option3 = option3;
    }
}