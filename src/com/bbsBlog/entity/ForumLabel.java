package com.bbsBlog.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ForumLabel database table.
 * 
 */
@Entity
@NamedQuery(name="ForumLabel.findAll", query="SELECT f FROM ForumLabel f")
public class ForumLabel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	//bi-directional many-to-one association to ForumPost
	@ManyToOne
	@JoinColumn(name="For_id")
	private ForumPost forumPost;

	//bi-directional many-to-one association to Label
	@ManyToOne
	@JoinColumn(name="lab_id")
	private Label label;

	public ForumLabel() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ForumPost getForumPost() {
		return this.forumPost;
	}

	public void setForumPost(ForumPost forumPost) {
		this.forumPost = forumPost;
	}

	public Label getLabel() {
		return this.label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

}