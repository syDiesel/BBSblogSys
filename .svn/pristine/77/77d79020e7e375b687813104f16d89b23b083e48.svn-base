package com.bbsBlog.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the FlagHis database table.
 * 
 */
@Entity
@Table(name="FlagHis")
@NamedQuery(name="FlagHi.findAll", query="SELECT f FROM FlagHi f")
public class FlagHi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Column(name="do_time")
	private String doTime;

	private String do_URL;

	@Column(name="do_user")
	private String doUser;

	@Column(name="do_way")
	private String doWay;

	@Column(name="re_cause")
	private String reCause;

	@Column(name="re_desc")
	private String reDesc;

	@Column(name="re_time")
	private String reTime;

	@Column(name="re_user")
	private String reUser;

	public FlagHi() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDoTime() {
		return this.doTime;
	}

	public void setDoTime(String doTime) {
		this.doTime = doTime;
	}

	public String getDo_URL() {
		return this.do_URL;
	}

	public void setDo_URL(String do_URL) {
		this.do_URL = do_URL;
	}

	public String getDoUser() {
		return this.doUser;
	}

	public void setDoUser(String doUser) {
		this.doUser = doUser;
	}

	public String getDoWay() {
		return this.doWay;
	}

	public void setDoWay(String doWay) {
		this.doWay = doWay;
	}

	public String getReCause() {
		return this.reCause;
	}

	public void setReCause(String reCause) {
		this.reCause = reCause;
	}

	public String getReDesc() {
		return this.reDesc;
	}

	public void setReDesc(String reDesc) {
		this.reDesc = reDesc;
	}

	public String getReTime() {
		return this.reTime;
	}

	public void setReTime(String reTime) {
		this.reTime = reTime;
	}

	public String getReUser() {
		return this.reUser;
	}

	public void setReUser(String reUser) {
		this.reUser = reUser;
	}

}