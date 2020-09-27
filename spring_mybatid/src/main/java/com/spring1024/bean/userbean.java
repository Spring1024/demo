package com.spring1024.bean;

import java.io.Serializable;

public class userbean implements Serializable {
    private int id;
    private String name;
    private String sex;
    private String email;
    private String tel;
    public userbean(int id,String name,String sex,String email,String tel){
        this.id=id;
        this.name=name;
        this.sex=sex;
        this.email=email;
        this.tel=tel;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "userbean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
