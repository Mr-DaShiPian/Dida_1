package com.qf.pojo;

public class User {
    private int userId;
    private String userName;
    private String password;
    private String role;
    private String name;

    public User(int userId, String userName, String password, String role, String name) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {
    }

    public User(String role) {
        this.role = role;
    }

    public User(int userId, String role) {
        this.userId = userId;
        this.role = role;
    }

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public User(int userId,  String name,String role) {
        this.userId = userId;
        this.name = name;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
