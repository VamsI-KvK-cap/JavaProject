package com.example.claims;

import java.util.Objects;

public class ClaimDataModel {
    private String chp01SystemOptions;
    private String chp20ReclaimMaster;
    private String chp07EquipMovementHistory;
    private String chp05TripControlNbr;
    private String chp05ReclaimCodeExt;
    private String d95TripControlNbr;
    private String chp07TripControlNbr;
    private String chp07DsTolRule5Receivable;
    private String chp07Delivery;

    public String getChp01SystemOptions() {
        return chp01SystemOptions;
    }

    public void setChp01SystemOptions(String chp01SystemOptions) {
        this.chp01SystemOptions = chp01SystemOptions;
    }

    public String getChp20ReclaimMaster() {
        return chp20ReclaimMaster;
    }

    public void setChp20ReclaimMaster(String chp20ReclaimMaster) {
        this.chp20ReclaimMaster = chp20ReclaimMaster;
    }

    public String getChp07EquipMovementHistory() {
        return chp07EquipMovementHistory;
    }

    public void setChp07EquipMovementHistory(String chp07EquipMovementHistory) {
        this.chp07EquipMovementHistory = chp07EquipMovementHistory;
    }

    public String getChp05TripControlNbr() {
        return chp05TripControlNbr;
    }

    public void setChp05TripControlNbr(String chp05TripControlNbr) {
        this.chp05TripControlNbr = chp05TripControlNbr;
    }

    public String getChp05ReclaimCodeExt() {
        return chp05ReclaimCodeExt;
    }

    public void setChp05ReclaimCodeExt(String chp05ReclaimCodeExt) {
        this.chp05ReclaimCodeExt = chp05ReclaimCodeExt;
    }

    public String getD95TripControlNbr() {
        return d95TripControlNbr;
    }

    public void setD95TripControlNbr(String d95TripControlNbr) {
        this.d95TripControlNbr = d95TripControlNbr;
    }

    public String getChp07TripControlNbr() {
        return chp07TripControlNbr;
    }

    public void setChp07TripControlNbr(String chp07TripControlNbr) {
        this.chp07TripControlNbr = chp07TripControlNbr;
    }

    public String getChp07DsTolRule5Receivable() {
        return chp07DsTolRule5Receivable;
    }

    public void setChp07DsTolRule5Receivable(String chp07DsTolRule5Receivable) {
        this.chp07DsTolRule5Receivable = chp07DsTolRule5Receivable;
    }

    public String getChp07Delivery() {
        return chp07Delivery;
    }

    public void setChp07Delivery(String chp07Delivery) {
        this.chp07Delivery = chp07Delivery;
    }

    public boolean validate() {
        return validateField(chp01SystemOptions) &&
               validateField(chp20ReclaimMaster) &&
               validateField(chp07EquipMovementHistory) &&
               validateField(chp05TripControlNbr) &&
               validateField(chp05ReclaimCodeExt) &&
               validateField(d95TripControlNbr) &&
               validateField(chp07TripControlNbr) &&
               validateField(chp07DsTolRule5Receivable) &&
               validateField(chp07Delivery);
    }

    private boolean validateField(String field) {
        if (field == null || field.isEmpty()) {
            throw new IllegalArgumentException("Field cannot be null or empty");
        }
        return true;
    }
}