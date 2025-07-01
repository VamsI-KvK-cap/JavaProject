package com.example.cycleheader;

import java.util.Date;

public class CycleHeader {
    private String cycleId;
    private Date startDate;
    private Date endDate;
    private String status;

    public CycleHeader(String cycleId, Date startDate, Date endDate, String status) {
        this.cycleId = cycleId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public String getCycleId() {
        return cycleId;
    }

    public void setCycleId(String cycleId) {
        this.cycleId = cycleId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
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