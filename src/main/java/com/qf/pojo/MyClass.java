package com.qf.pojo;

public class MyClass {
    private int id;
    private String cid;
    private String cName;
    private String tName;
    private String bName;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
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
    public MyClass(String cName, String tName) {
        this.cName = cName;
        this.tName = tName;
    }

    public MyClass(int id, String cName, String tName) {
        this.id = id;
        this.cName = cName;
        this.tName = tName;
    }

    public MyClass(int id, String cid, String cName, String tName, String bName) {
        this.id = id;
        this.cid = cid;
        this.cName = cName;
        this.tName = tName;
        this.bName = bName;
    }

    public MyClass() {
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "id=" + id +
                ", cid='" + cid + '\'' +
                ", cName='" + cName + '\'' +
                ", tName='" + tName + '\'' +
                ", bName='" + bName + '\'' +
                '}';
    }
}
