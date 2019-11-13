package com.qf.pojo;

public class User {
    private int userId;
    private String userName;
    private String password;
    private String role;

    @Override
    public String toString() {
        return "User{" +
                "uesrId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public int getUesrId() {
        return userId;
    }

    public void setUesrId(int uesrId) {
        this.userId = uesrId;
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

    public User(int userId, String role) {
        this.userId = userId;
        this.role = role;
    }

    public User(int uesrId) {
        this.userId = uesrId;
    }

    public User() {
    }

    public User(String role) {
        this.role = role;
    }
}
