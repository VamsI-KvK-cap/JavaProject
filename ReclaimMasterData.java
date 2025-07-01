package com.example.reclaim;

public class ReclaimMasterData {
    private String reclaimCode;
    private String reclaimCodeExt;
    private String effectiveMonth;
    private String expireMonth;
    private String userRoad;
    private Boolean isVoluntary;
    private Boolean isEstimate;

    public ReclaimMasterData(String reclaimCode, String reclaimCodeExt, String effectiveMonth, 
                             String expireMonth, String userRoad, Boolean isVoluntary, 
                             Boolean isEstimate) {
        setReclaimCode(reclaimCode);
        setReclaimCodeExt(reclaimCodeExt);
        setEffectiveMonth(effectiveMonth);
        setExpireMonth(expireMonth);
        setUserRoad(userRoad);
        setIsVoluntary(isVoluntary);
        setIsEstimate(isEstimate);
    }

    public String getReclaimCode() {
        return reclaimCode;
    }

    public void setReclaimCode(String reclaimCode) {
        if (reclaimCode == null || reclaimCode.isEmpty()) {
            throw new IllegalArgumentException("Reclaim code cannot be null or empty");
        }
        this.reclaimCode = reclaimCode;
    }

    public String getReclaimCodeExt() {
        return reclaimCodeExt;
    }

    public void setReclaimCodeExt(String reclaimCodeExt) {
        if (reclaimCodeExt == null || reclaimCodeExt.isEmpty()) {
            throw new IllegalArgumentException("Reclaim code extension cannot be null or empty");
        }
        this.reclaimCodeExt = reclaimCodeExt;
    }

    public String getEffectiveMonth() {
        return effectiveMonth;
    }

    public void setEffectiveMonth(String effectiveMonth) {
        if (effectiveMonth == null || effectiveMonth.isEmpty()) {
            throw new IllegalArgumentException("Effective month cannot be null or empty");
        }
        this.effectiveMonth = effectiveMonth;
    }

    public String getExpireMonth() {
        return expireMonth;
    }

    public void setExpireMonth(String expireMonth) {
        if (expireMonth == null || expireMonth.isEmpty()) {
            throw new IllegalArgumentException("Expire month cannot be null or empty");
        }
        this.expireMonth = expireMonth;
    }

    public String getUserRoad() {
        return userRoad;
    }

    public void setUserRoad(String userRoad) {
        if (userRoad == null || userRoad.isEmpty()) {
            throw new IllegalArgumentException("User road cannot be null or empty");
        }
        this.userRoad = userRoad;
    }

    public Boolean getIsVoluntary() {
        return isVoluntary;
    }

    public void setIsVoluntary(Boolean isVoluntary) {
        this.isVoluntary = isVoluntary;
    }

    public Boolean getIsEstimate() {
        return isEstimate;
    }

    public void setIsEstimate(Boolean isEstimate) {
        this.isEstimate = isEstimate;
    }
}