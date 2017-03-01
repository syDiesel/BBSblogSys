package com.bbsBlog.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TPJL database table.
 * 
 */
@Entity
@Table(name="TPJL")
@NamedQuery(name="Tpjl.findAll", query="SELECT t FROM Tpjl t")
public class Tpjl implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	//bi-directional many-to-one association to ForumTP
	@ManyToOne
	@JoinColumn(name="For_id")
	private ForumTP forumTp;

	//bi-directional many-to-one association to UserInfo
	@ManyToOne
	@JoinColumn(name="Use_id")
	private UserInfo userInfo;

	public Tpjl() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ForumTP getForumTp() {
		return this.forumTp;
	}

	public void setForumTp(ForumTP forumTp) {
		this.forumTp = forumTp;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}