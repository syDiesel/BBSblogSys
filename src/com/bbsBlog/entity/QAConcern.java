package com.bbsBlog.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/*
 * @author zhou junlong
 */
@Entity
@Table(name="QAConcern")
@NamedQuery(name="QAConcern.findAll", query="SELECT u FROM QAConcern u")
public class QAConcern  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public QAConcern() {
		super();
	}
	
	public QAConcern(UserInfo userInfo, Question question, String time) {
		super();
		this.userInfo = userInfo;
		this.question = question;
		this.time = time;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name="UserInfo_id")
	private UserInfo userInfo;
	
	@ManyToOne
	@JoinColumn(name="Question_id")
	private Question question;
	
	@Column(name="time")
	private String time;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}