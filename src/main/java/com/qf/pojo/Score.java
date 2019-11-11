package com.qf.pojo;

public class Score {
    private int sid;
    private String stuName;
    private Double stageA;
    private Double stageB;
    private Double stageC;
    private Double stageD;

    @Override
    public String toString() {
        return "Score{" +
                "sid=" + sid +
                ", stuName='" + stuName + '\'' +
                ", stageA=" + stageA +
                ", stageB=" + stageB +
                ", stageC=" + stageC +
                ", stageD=" + stageD +
                '}';
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Double getStageA() {
        return stageA;
    }

    public void setStageA(Double stageA) {
        this.stageA = stageA;
    }

    public Double getStageB() {
        return stageB;
    }

    public void setStageB(Double stageB) {
        this.stageB = stageB;
    }

    public Double getStageC() {
        return stageC;
    }

    public void setStageC(Double stageC) {
        this.stageC = stageC;
    }

    public Double getStageD() {
        return stageD;
    }

    public void setStageD(Double stageD) {
        this.stageD = stageD;
    }
}
