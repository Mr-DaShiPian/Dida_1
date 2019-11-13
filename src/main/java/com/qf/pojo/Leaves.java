package com.qf.pojo;

public class Leaves {
    private int lid;
    private String stuName;
    private String startDate;
    private String endDate;
    private String cause;
    private String tName;
    private String bName;
    private String boos;
    private String status;
    private String instanceId;

    @Override
    public String toString() {
        return "Leaves{" +
                "lid=" + lid +
                ", stuName='" + stuName + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", cause='" + cause + '\'' +
                ", tName='" + tName + '\'' +
                ", bName='" + bName + '\'' +
                ", boos='" + boos + '\'' +
                ", status='" + status + '\'' +
                ", instanceId='" + instanceId + '\'' +
                '}';
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public String getBoos() {
        return boos;
    }

    public void setBoos(String boos) {
        this.boos = boos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }
}
