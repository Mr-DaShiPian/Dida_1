package com.qf.pojo;

import java.util.List;

public class StudentAndClass {
    private int id;
    private int cid;
    private String cName;
    private String tName;
    private String bName;
    private List<Student> studentList;

    @Override
    public String toString() {

        return "StudentAndClass{" +
                "id=" + id +
                ", cid=" + cid +
                ", cName='" + cName + '\'' +
                ", tName='" + tName + '\'' +
                ", bName='" + bName + '\'' +
                ", studentList=" + studentList +
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

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public StudentAndClass() {
    }

    public StudentAndClass(int id, int cid, String cName, String tName, String bName, List<Student> studentList) {
        this.id = id;
        this.cid = cid;
        this.cName = cName;
        this.tName = tName;
        this.bName = bName;
        this.studentList = studentList;
    }
}
