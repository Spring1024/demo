package com.spring1024.util;

/**
 * 负责给前端页面传递信息
 * 
 * @author xzc
 *
 */
public class Message {

	private String mess;
	private String bool;

	public Message(String mess, String bool) {
		super();
		this.mess = mess;
		this.bool = bool;
	}

	public String getMess() {
		return mess;
	}

	public void setMess(String mess) {
		this.mess = mess;
	}

	public String getBool() {
		return bool;
	}

	public void setBool(String bool) {
		this.bool = bool;
	}

}