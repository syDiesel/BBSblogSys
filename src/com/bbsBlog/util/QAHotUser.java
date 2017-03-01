package com.bbsBlog.util;
/**
 * 
 * @author Zhou Junlong
 * @Date 2014年12月28日下午7:58:12
 * @Method 热门问答用户
 */
public class QAHotUser {
	int uid;
	String uname;
	int bid;
	String bname;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public QAHotUser(int uid, String uname, int bid, String bname) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.bid = bid;
		this.bname = bname;
	}
	public QAHotUser() {
		super();
		// TODO Auto-generated constructor stub
	}
}
