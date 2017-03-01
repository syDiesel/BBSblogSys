package com.bbsBlog.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the QuestionLabel database table.
 * 
 */
@Entity
@NamedQuery(name="QuestionLabel.findAll", query="SELECT q FROM QuestionLabel q")
public class QuestionLabel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	//bi-directional many-to-one association to Label
	@ManyToOne
	@JoinColumn(name="lab_id")
	private Label label;

	//bi-directional many-to-one association to Question
	@ManyToOne
	@JoinColumn(name="Que_id")
	private Question question;

	public QuestionLabel() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Label getLabel() {
		return this.label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}