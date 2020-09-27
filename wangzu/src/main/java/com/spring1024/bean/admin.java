package com.spring1024.bean;

import java.io.Serializable;
import java.util.List;

public class admin implements Serializable{

	private static final long serialVersionUID = 1L;
	private String aid;
	private String aname;
	private String apwd;
	private int rid;

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApwd() {
		return apwd;
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;
	} 
	public admin() {
	}

	@Override
	public String toString() {
		return "admin{" +
				"aid='" + aid + '\'' +
				", aname='" + aname + '\'' +
				", apwd='" + apwd + '\'' +
				", rid='" + rid + '\'' +
				'}';
	}

}
