package com.qf.pojo;

public class User {
    private int uesrId;
    private String userName;
    private String password;
    private String role;

    @Override
    public String toString() {
        return "User{" +
                "uesrId=" + uesrId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public int getUesrId() {
        return uesrId;
    }

    public void setUesrId(int uesrId) {
        this.uesrId = uesrId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
