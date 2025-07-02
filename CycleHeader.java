package com.example.cycleheader;

import java.util.Date;

public class CycleHeader {
    private String cycleId;
    private Date startDate;
    private Date endDate;
    private String status;

    public CycleHeader(String cycleId, Date startDate, Date endDate, String status) {
        if (cycleId == null || cycleId.isEmpty()) {
            throw new IllegalArgumentException("Cycle ID cannot be null or empty");
        }
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Start date and end date cannot be null");
        }
        if (startDate.after(endDate)) {
            throw new IllegalArgumentException("Start date must be before end date");
        }
        this.cycleId = cycleId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public String getCycleId() {
        return cycleId;
    }

    public void setCycleId(String cycleId) {
        if (cycleId == null || cycleId.isEmpty()) {
            throw new IllegalArgumentException("Cycle ID cannot be null or empty");
        }
        this.cycleId = cycleId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        if (startDate == null) {
            throw new IllegalArgumentException("Start date cannot be null");
        }
        if (startDate.after(endDate)) {
            throw new IllegalArgumentException("Start date must be before end date");
        }
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        if (endDate == null) {
            throw new IllegalArgumentException("End date cannot be null");
        }
        if (startDate.after(endDate)) {
            throw new IllegalArgumentException("Start date must be before end date");
        }
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isActive() {
        Date now = new Date();
        return now.after(startDate) && now.before(endDate);
    }
}