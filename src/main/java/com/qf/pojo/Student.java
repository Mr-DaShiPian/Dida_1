package com.qf.pojo;

public class Student {
    private int stuId;
    private String stuName;
    private int stuAge;
    private String stuSex;
    private String stuBirthday;
    private String stuTel;
    private int cid;

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuAge=" + stuAge +
                ", stuSex='" + stuSex + '\'' +
                ", stuBirthday='" + stuBirthday + '\'' +
                ", stuTel='" + stuTel + '\'' +
                ", cid=" + cid +
                '}';
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getStuBirthday() {
        return stuBirthday;
    }

    public void setStuBirthday(String stuBirthday) {
        this.stuBirthday = stuBirthday;
    }

    public String getStuTel() {
        return stuTel;
    }

    public void setStuTel(String stuTel) {
        this.stuTel = stuTel;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
