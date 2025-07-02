package com.example.claims;

public class ReclaimMaster {
    private String reclaimCode;
    private String userRoad;

    public String getReclaimCode() {
        return reclaimCode;
    }

    public void setReclaimCode(String reclaimCode) {
        this.reclaimCode = reclaimCode;
    }

    public String getUserRoad() {
        return userRoad;
    }

    public void setUserRoad(String userRoad) {
        this.userRoad = userRoad;
    }

    public void initialize(String reclaimCode, String userRoad) {
        this.reclaimCode = reclaimCode;
        this.userRoad = userRoad;
    }

    public boolean validate() {
        return reclaimCode != null && !reclaimCode.isEmpty() && userRoad != null && !userRoad.isEmpty();
    }
}