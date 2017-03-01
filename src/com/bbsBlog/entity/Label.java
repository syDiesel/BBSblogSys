package com.bbsBlog.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the Label database table.
 * 
 */
@Entity
@NamedQuery(name = "Label.findAll", query = "SELECT l FROM Label l")
public class Label implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "forumCount")
	private long forumCount;

	@Column(name = "blogCount")
	private long blogCount;

	@Column(name = "questionCount")
	private long questionCount;

	public long getForumCount() {
		return forumCount;
	}

	public void setForumCount(long forumCount) {
		this.forumCount = forumCount;
	}

	public long getBlogCount() {
		return blogCount;
	}

	public void setBlogCount(long blogCount) {
		this.blogCount = blogCount;
	}

	public long getQuestionCount() {
		return questionCount;
	}

	public void setQuestionCount(long questionCount) {
		this.questionCount = questionCount;
	}

	@Lob
	@Column(name = "label_desc")
	private String labelDesc;

	@Column(name = "label_name")
	private String labelName;

	@Column(name = "label_pic")
	private String labelPic;

	// bi-directional many-to-one association to BlogLabel
	@OneToMany(mappedBy = "label", cascade = CascadeType.ALL)
	private List<BlogLabel> blogLabels;

	// bi-directional many-to-one association to ForumLabel
	@OneToMany(mappedBy = "label", cascade = CascadeType.ALL)
	private List<ForumLabel> forumLabels;

	// bi-directional many-to-one association to Board
	@ManyToOne
	@JoinColumn(name = "boa_id")
	private Board board;

	// bi-directional many-to-one association to QuestionLabel
	@OneToMany(mappedBy = "label", cascade = CascadeType.ALL)
	private List<QuestionLabel> questionLabels;

	public Label() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLabelDesc() {
		return this.labelDesc;
	}

	public void setLabelDesc(String labelDesc) {
		this.labelDesc = labelDesc;
	}

	public String getLabelName() {
		return this.labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public String getLabelPic() {
		return this.labelPic;
	}

	public void setLabelPic(String labelPic) {
		this.labelPic = labelPic;
	}

	public List<BlogLabel> getBlogLabels() {
		return this.blogLabels;
	}

	public void setBlogLabels(List<BlogLabel> blogLabels) {
		this.blogLabels = blogLabels;
	}

	public BlogLabel addBlogLabel(BlogLabel blogLabel) {
		getBlogLabels().add(blogLabel);
		blogLabel.setLabel(this);

		return blogLabel;
	}

	public BlogLabel removeBlogLabel(BlogLabel blogLabel) {
		getBlogLabels().remove(blogLabel);
		blogLabel.setLabel(null);

		return blogLabel;
	}

	public List<ForumLabel> getForumLabels() {
		return this.forumLabels;
	}

	public void setForumLabels(List<ForumLabel> forumLabels) {
		this.forumLabels = forumLabels;
	}

	public ForumLabel addForumLabel(ForumLabel forumLabel) {
		getForumLabels().add(forumLabel);
		forumLabel.setLabel(this);

		return forumLabel;
	}

	public ForumLabel removeForumLabel(ForumLabel forumLabel) {
		getForumLabels().remove(forumLabel);
		forumLabel.setLabel(null);

		return forumLabel;
	}

	public Board getBoard() {
		return this.board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public List<QuestionLabel> getQuestionLabels() {
		return this.questionLabels;
	}

	public void setQuestionLabels(List<QuestionLabel> questionLabels) {
		this.questionLabels = questionLabels;
	}

	public QuestionLabel addQuestionLabel(QuestionLabel questionLabel) {
		getQuestionLabels().add(questionLabel);
		questionLabel.setLabel(this);

		return questionLabel;
	}

	public QuestionLabel removeQuestionLabel(QuestionLabel questionLabel) {
		getQuestionLabels().remove(questionLabel);
		questionLabel.setLabel(null);

		return questionLabel;
	}

}