package com.spring1024.bean;

import java.util.Date;

public class dataCount {
    private String date;
    private int count;

    public dataCount(String data, int count) {
        this.date = data;
        this.count = count;
    }

    @Override
    public String toString() {
        return "dataCount{" +
                "date=" + date +
                ", count=" + count +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setData(String data) {
        this.date = date;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
