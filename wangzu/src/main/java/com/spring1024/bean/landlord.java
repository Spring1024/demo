package com.spring1024.bean;

import java.io.Serializable;

public class landlord implements Serializable{
	private static final long serialVersionUID = 1L;
	private String lid;
	private String lname;
	private String ltel;
	private String hid;
	private String idCard;
	private String lpwd;
	private String ldate;
	private int rid;

	@Override
	public String toString() {
		return "landlord{" +
				"lid='" + lid + '\'' +
				", lname='" + lname + '\'' +
				", ltel='" + ltel + '\'' +
				", hid='" + hid + '\'' +
				", idCard='" + idCard + '\'' +
				", lpwd='" + lpwd + '\'' +
				", ldate='" + ldate + '\'' +
				", rid=" + rid +
				'}';
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getLid() {
		return lid;
	}

	public void setLid(String lid) {
		this.lid = lid;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getLtel() {
		return ltel;
	}

	public void setLtel(String ltel) {
		this.ltel = ltel;
	}

	public String getHid() {
		return hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getLpwd() {
		return lpwd;
	}

	public void setLpwd(String lpwd) {
		this.lpwd = lpwd;
	}

	public String getLdate() {
		return ldate;
	}

	public void setLdate(String ldate) {
		this.ldate = ldate;
	}

	public landlord() {
		
	}
	
	public landlord(String lname, String ltel, String idCard) {
		
		this.lname=lname;
		this.ltel=ltel;
		this.idCard=idCard;
	}

}
