package com.bbsBlog.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ForumUpHis database table.
 * 
 */
@Entity
@Table(name="ForumUpHis")
@NamedQuery(name="ForumUpHi.findAll", query="SELECT f FROM ForumUpHi f")
public class ForumUpHi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Lob
	@Column(name="UpContent")
	private String upContent;

	@Column(name="UpTime")
	private String upTime;

	//bi-directional many-to-one association to ForumPost
	@ManyToOne
	@JoinColumn(name="For_id")
	private ForumPost forumPost;

	//bi-directional many-to-one association to UserInfo
	@ManyToOne
	@JoinColumn(name="Use_id")
	private UserInfo userInfo;

	public ForumUpHi() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUpContent() {
		return this.upContent;
	}

	public void setUpContent(String upContent) {
		this.upContent = upContent;
	}

	public String getUpTime() {
		return this.upTime;
	}

	public void setUpTime(String upTime) {
		this.upTime = upTime;
	}

	public ForumPost getForumPost() {
		return this.forumPost;
	}

	public void setForumPost(ForumPost forumPost) {
		this.forumPost = forumPost;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}