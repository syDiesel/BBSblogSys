package com.bbsBlog.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the BlogLabel database table.
 * 
 */
@Entity
@NamedQuery(name="BlogLabel.findAll", query="SELECT b FROM BlogLabel b")
public class BlogLabel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	//bi-directional many-to-one association to BlogLog
	@ManyToOne
	@JoinColumn(name="blo_id")
	private BlogLog blogLog;

	//bi-directional many-to-one association to Label
	@ManyToOne
	@JoinColumn(name="lab_id")
	private Label label;

	public BlogLabel() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BlogLog getBlogLog() {
		return this.blogLog;
	}

	public void setBlogLog(BlogLog blogLog) {
		this.blogLog = blogLog;
	}

	public Label getLabel() {
		return this.label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

}