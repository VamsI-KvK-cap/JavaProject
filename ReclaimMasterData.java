package com.example.reclaim;

public class ReclaimMasterData {
    private String CHP20_RECLAIM_MASTER;
    private String CHP20_USER_ROAD;
    private String CHP20_RECLAIM_CODE;
    private String CHP20_RECLAIM_CODE_EXT;
    private String CHP20_EFFECTIVE_MONTH;
    private String CHP20_EXPIRE_MONTH;
    private String voluntaryStatus;
    private String estimateStatus;

    public ReclaimMasterData(String CHP20_RECLAIM_MASTER, String CHP20_USER_ROAD, String CHP20_RECLAIM_CODE, 
                             String CHP20_RECLAIM_CODE_EXT, String CHP20_EFFECTIVE_MONTH, 
                             String CHP20_EXPIRE_MONTH, String voluntaryStatus, String estimateStatus) {
        setCHP20_RECLAIM_MASTER(CHP20_RECLAIM_MASTER);
        setCHP20_USER_ROAD(CHP20_USER_ROAD);
        setCHP20_RECLAIM_CODE(CHP20_RECLAIM_CODE);
        setCHP20_RECLAIM_CODE_EXT(CHP20_RECLAIM_CODE_EXT);
        setCHP20_EFFECTIVE_MONTH(CHP20_EFFECTIVE_MONTH);
        setCHP20_EXPIRE_MONTH(CHP20_EXPIRE_MONTH);
        setVoluntaryStatus(voluntaryStatus);
        setEstimateStatus(estimateStatus);
    }

    public String getCHP20_RECLAIM_MASTER() {
        return CHP20_RECLAIM_MASTER;
    }

    public void setCHP20_RECLAIM_MASTER(String CHP20_RECLAIM_MASTER) {
        if (CHP20_RECLAIM_MASTER == null || CHP20_RECLAIM_MASTER.isEmpty()) {
            throw new IllegalArgumentException("CHP20_RECLAIM_MASTER cannot be null or empty");
        }
        this.CHP20_RECLAIM_MASTER = CHP20_RECLAIM_MASTER;
    }

    public String getCHP20_USER_ROAD() {
        return CHP20_USER_ROAD;
    }

    public void setCHP20_USER_ROAD(String CHP20_USER_ROAD) {
        if (CHP20_USER_ROAD == null || CHP20_USER_ROAD.isEmpty()) {
            throw new IllegalArgumentException("CHP20_USER_ROAD cannot be null or empty");
        }
        this.CHP20_USER_ROAD = CHP20_USER_ROAD;
    }

    public String getCHP20_RECLAIM_CODE() {
        return CHP20_RECLAIM_CODE;
    }

    public void setCHP20_RECLAIM_CODE(String CHP20_RECLAIM_CODE) {
        if (CHP20_RECLAIM_CODE == null || CHP20_RECLAIM_CODE.isEmpty()) {
            throw new IllegalArgumentException("CHP20_RECLAIM_CODE cannot be null or empty");
        }
        this.CHP20_RECLAIM_CODE = CHP20_RECLAIM_CODE;
    }

    public String getCHP20_RECLAIM_CODE_EXT() {
        return CHP20_RECLAIM_CODE_EXT;
    }

    public void setCHP20_RECLAIM_CODE_EXT(String CHP20_RECLAIM_CODE_EXT) {
        if (CHP20_RECLAIM_CODE_EXT == null || CHP20_RECLAIM_CODE_EXT.isEmpty()) {
            throw new IllegalArgumentException("CHP20_RECLAIM_CODE_EXT cannot be null or empty");
        }
        this.CHP20_RECLAIM_CODE_EXT = CHP20_RECLAIM_CODE_EXT;
    }

    public String getCHP20_EFFECTIVE_MONTH() {
        return CHP20_EFFECTIVE_MONTH;
    }

    public void setCHP20_EFFECTIVE_MONTH(String CHP20_EFFECTIVE_MONTH) {
        if (CHP20_EFFECTIVE_MONTH == null || CHP20_EFFECTIVE_MONTH.isEmpty()) {
            throw new IllegalArgumentException("CHP20_EFFECTIVE_MONTH cannot be null or empty");
        }
        this.CHP20_EFFECTIVE_MONTH = CHP20_EFFECTIVE_MONTH;
    }

    public String getCHP20_EXPIRE_MONTH() {
        return CHP20_EXPIRE_MONTH;
    }

    public void setCHP20_EXPIRE_MONTH(String CHP20_EXPIRE_MONTH) {
        if (CHP20_EXPIRE_MONTH == null || CHP20_EXPIRE_MONTH.isEmpty()) {
            throw new IllegalArgumentException("CHP20_EXPIRE_MONTH cannot be null or empty");
        }
        this.CHP20_EXPIRE_MONTH = CHP20_EXPIRE_MONTH;
    }

    public String getVoluntaryStatus() {
        return voluntaryStatus;
    }

    public void setVoluntaryStatus(String voluntaryStatus) {
        if (voluntaryStatus == null || voluntaryStatus.isEmpty()) {
            throw new IllegalArgumentException("Voluntary status cannot be null or empty");
        }
        this.voluntaryStatus = voluntaryStatus;
    }

    public String getEstimateStatus() {
        return estimateStatus;
    }

    public void setEstimateStatus(String estimateStatus) {
        if (estimateStatus == null || estimateStatus.isEmpty()) {
            throw new IllegalArgumentException("Estimate status cannot be null or empty");
        }
        this.estimateStatus = estimateStatus;
    }
}