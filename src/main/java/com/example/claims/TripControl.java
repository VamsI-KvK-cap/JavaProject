package com.example.claims;

import java.util.regex.Pattern;

public class TripControl {
    private String tripControlNumber;
    private static final Pattern TRIP_CONTROL_NUMBER_PATTERN = Pattern.compile("^[A-Z]{5}-[A-Z]{4}-[0-9]{1,5}$");

    public TripControl(String tripControlNumber) {
        if (!isValidTripControlNumber(tripControlNumber)) {
            throw new IllegalArgumentException("Invalid trip control number format.");
        }
        this.tripControlNumber = tripControlNumber;
    }

    public String getTripControlNumber() {
        return tripControlNumber;
    }

    public boolean isValidTripControlNumber(String tripControlNumber) {
        return TRIP_CONTROL_NUMBER_PATTERN.matcher(tripControlNumber).matches();
    }

    public void setTripControlNumber(String tripControlNumber) {
        if (!isValidTripControlNumber(tripControlNumber)) {
            throw new IllegalArgumentException("Invalid trip control number format.");
        }
        this.tripControlNumber = tripControlNumber;
    }
}