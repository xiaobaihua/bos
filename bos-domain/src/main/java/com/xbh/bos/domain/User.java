package com.xbh.bos.domain;

public class User {
    private String user_Id;

    private String username;

    private String password;

    public String getUserId() {
        return user_Id;
    }

    public void setUserId(String userId) {
        this.user_Id = userId == null ? null : userId.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}