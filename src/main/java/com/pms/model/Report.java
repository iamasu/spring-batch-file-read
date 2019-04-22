package com.pms.model;

public class Report {

    private long id;
    private String impressions;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImpressions() {
        return impressions;
    }

    public void setImpressions(String impressions) {
        this.impressions = impressions;
    }

    @Override
    public String toString() {
        return String.format("%0$-9s", id) + String.format("%0$-21s", impressions);
    }

}
