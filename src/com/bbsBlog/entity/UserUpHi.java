package com.bbsBlog.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the UserUpHis database table.
 * 
 */
@Entity
@Table(name="UserUpHis")
@NamedQuery(name="UserUpHi.findAll", query="SELECT u FROM UserUpHi u")
public class UserUpHi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String time;

	//bi-directional many-to-one association to BlogLog
	@ManyToOne
	@JoinColumn(name="blog_id")
	private BlogLog blogLog;

	//bi-directional many-to-one association to UserInfo
	@ManyToOne
	@JoinColumn(name="User_id")
	private UserInfo userInfo;

	public UserUpHi() {
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

	public BlogLog getBlogLog() {
		return this.blogLog;
	}

	public void setBlogLog(BlogLog blogLog) {
		this.blogLog = blogLog;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}