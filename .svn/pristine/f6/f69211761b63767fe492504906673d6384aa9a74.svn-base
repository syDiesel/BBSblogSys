package com.bbsBlog.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the RechargeHis database table.
 * 
 */
@Entity
@Table(name="RechargeHis")
@NamedQuery(name="RechargeHi.findAll", query="SELECT r FROM RechargeHi r")
public class RechargeHi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String time;

	private String value;

	//bi-directional many-to-one association to UserInfo
	@ManyToOne
	@JoinColumn(name="UserInfo_id")
	private UserInfo userInfo;

	public RechargeHi() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}