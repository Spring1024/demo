package com.spring1024.bean;

public class user {
    private String uid;
    private String uname;
    private String upwd;
    private long utel;
    private String udate;

    @Override
    public String toString() {
        return "user{" +
                "uid='" + uid + '\'' +
                ", uname='" + uname + '\'' +
                ", upwd='" + upwd + '\'' +
                ", utel=" + utel +
                ", udate='" + udate + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getUdate() {
        return udate;
    }

    public void setUdate(String udate) {
        this.udate = udate;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public long getUtel() {
        return utel;
    }

    public void setUtel(long utel) {
        this.utel = utel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;
}
