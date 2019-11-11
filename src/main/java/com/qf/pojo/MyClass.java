package com.qf.pojo;

public class MyClass {
    private int id;
    private int cid;
    private String stuName;
    private String tName;
    private String bName;

    @Override
    public String toString() {
        return "MyClass{" +
                "id=" + id +
                ", cid=" + cid +
                ", stuName='" + stuName + '\'' +
                ", tName='" + tName + '\'' +
                ", bName='" + bName + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
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
}
