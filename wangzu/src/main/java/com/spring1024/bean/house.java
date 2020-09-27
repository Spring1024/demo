package com.spring1024.bean;

public class house {
	private String hid;
	private String hname;
	private int hprice;
	private int htype;
	private int harea;
	private String hmodel;
	private String hfloor;
	private String hposition;
	private String hsubway;
	private String htele;
	private String himg;
	private String hdesc;
	private int hstate;
	private String hbelong;
	private int hclick;
	private String hdate;
	private String haddress;

	@Override
	public String toString() {
		return "house{" +
				"hid='" + hid + '\'' +
				", hname='" + hname + '\'' +
				", hprice=" + hprice +
				", htype=" + htype +
				", harea=" + harea +
				", hmodel='" + hmodel + '\'' +
				", hfloor='" + hfloor + '\'' +
				", hposition='" + hposition + '\'' +
				", hsubway='" + hsubway + '\'' +
				", htele='" + htele + '\'' +
				", himg='" + himg + '\'' +
				", hdesc='" + hdesc + '\'' +
				", hstate=" + hstate +
				", hbelong='" + hbelong + '\'' +
				", hclick=" + hclick +
				", hdate='" + hdate + '\'' +
				", haddress='" + haddress + '\'' +
				'}';
	}

	public String getHaddress() {
		return haddress;
	}

	public void setHaddress(String haddress) {
		this.haddress = haddress;
	}

	public int getHstate() {
		return hstate;
	}

	public String getHdate() {
		return hdate;
	}

	public void setHdate(String hdate) {
		this.hdate = hdate;
	}

	public int getHclick() {
		return hclick;
	}
	public void setHclick(int hclick) {
		this.hclick = hclick;
	}
	public String getHbelong() {
		return hbelong;
	}
	public void setHbelong(String hbelong) {
		this.hbelong = hbelong;
	}
	public String getHid() {
		return hid;
	}
	public void setHid(String hid) {
		this.hid = hid;
	}
	public String getHname() {
		return hname;
	}
	public void setHname(String hname) {
		this.hname = hname;
	}
	public int getHprice() {
		return hprice;
	}
	public void setHprice(int hprice) {
		this.hprice = hprice;
	}
	public int getHtype() {
		return htype;
	}
	public void setHtype(int htype) {
		this.htype = htype;
	}
	public int getHarea() {
		return harea;
	}
	public void setHarea(int harea) {
		this.harea = harea;
	}
	public String getHmodel() {
		return hmodel;
	}
	public void setHmodel(String hmodel) {
		this.hmodel = hmodel;
	}
	public String getHfloor() {
		return hfloor;
	}
	public void setHfloor(String hfloor) {
		this.hfloor = hfloor;
	}
	public String getHposition() {
		return hposition;
	}
	public void setHposition(String hposition) {
		this.hposition = hposition;
	}
	public String getHsubway() {
		return hsubway;
	}
	public void setHsubway(String hsubway) {
		this.hsubway = hsubway;
	}
	public String getHtele() {
		return htele;
	}
	public void setHtele(String htele) {
		this.htele = htele;
	}
	public String getHimg() {
		return himg;
	}
	public void setHimg(String himg) {
		this.himg = himg;
	}
	public String getHdesc() {
		return hdesc;
	}
	public void setHdesc(String hdesc) {
		this.hdesc = hdesc;
	}
	public void setHstate(int i) {
		this.hstate = i;
	}

}
