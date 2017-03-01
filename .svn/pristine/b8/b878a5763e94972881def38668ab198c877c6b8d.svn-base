package com.bbsBlog.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the QuestionPJ database table.
 * 
 */
@Entity
@NamedQuery(name="QuestionPJ.findAll", query="SELECT q FROM QuestionPJ q")
public class QuestionPJ implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String commitType;

	//bi-directional many-to-one association to Answer
	@ManyToOne
	@JoinColumn(name="Ans_id")
	private Answer answer;

	//bi-directional many-to-one association to UserInfo
	@ManyToOne
	@JoinColumn(name="Use_id")
	private UserInfo userInfo;

	public QuestionPJ() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCommentText() {
		return this.commitType;
	}

	public void setCommentText(String commitType) {
		this.commitType = commitType;
	}

	public Answer getAnswer() {
		return this.answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}