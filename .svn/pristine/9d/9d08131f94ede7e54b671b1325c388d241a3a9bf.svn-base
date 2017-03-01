package com.bbsBlog.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ForumTP database table.
 * 
 */
@Entity
@NamedQuery(name="ForumTP.findAll", query="SELECT f FROM ForumTP f")
public class ForumTP implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String beginTime;

	private String endTime;

	private String other;

	private String TPcount;

	private String TPsubject;
	
	private String TPtitle;

	public String getTPtitle() {
		return TPtitle;
	}

	public void setTPtitle(String tPtitle) {
		TPtitle = tPtitle;
	}

	//bi-directional many-to-one association to ForumPost
	@ManyToOne
	@JoinColumn(name="For_id")
	private ForumPost forumPost;

	//bi-directional many-to-one association to Tpjl
	@OneToMany(mappedBy="forumTp")
	private List<Tpjl> tpjls;

	public ForumTP() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return this.endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getTPcount() {
		return this.TPcount;
	}

	public void setTPcount(String TPcount) {
		this.TPcount = TPcount;
	}

	public String getTPsubject() {
		return this.TPsubject;
	}

	public void setTPsubject(String TPsubject) {
		this.TPsubject = TPsubject;
	}

	public ForumPost getForumPost() {
		return this.forumPost;
	}

	public void setForumPost(ForumPost forumPost) {
		this.forumPost = forumPost;
	}

	public List<Tpjl> getTpjls() {
		return this.tpjls;
	}

	public void setTpjls(List<Tpjl> tpjls) {
		this.tpjls = tpjls;
	}

	public Tpjl addTpjl(Tpjl tpjl) {
		getTpjls().add(tpjl);
		tpjl.setForumTp(this);

		return tpjl;
	}

	public Tpjl removeTpjl(Tpjl tpjl) {
		getTpjls().remove(tpjl);
		tpjl.setForumTp(null);

		return tpjl;
	}

}