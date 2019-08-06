package com.shopping.easy.model;

import java.io.Serializable;

public class UserModel implements Serializable{
    private Integer userId;
    private String user_name;
    private String account;
    private String password;
    private String stage;
    private Integer age;

    private String token;

    @Override
    public String toString() {
        return "UserModel{" +
                "userId=" + userId +
                ", user_name='" + user_name + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", stage='" + stage + '\'' +
                ", age=" + age +
                ", token='" + token + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
