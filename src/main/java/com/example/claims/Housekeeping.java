package com.example.claims;

import java.io.Closeable;
import java.io.IOException;

public class Housekeeping {
    private Closeable resource;

    public Housekeeping(Closeable resource) {
        this.resource = resource;
    }

    public void perform() {
        try {
            if (resource != null) {
                resource.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}