package com.bbsBlog.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the Board database table.
 * 
 */
@Entity
@NamedQuery(name="Board.findAll", query="SELECT b FROM Board b")
public class Board implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	@Lob
	@Column(name="board_desc")
	private String boardDesc;

	@Column(name="board_name")
	private String boardName;

	@Column(name="board_pic")
	private String boardPic;

	private String isVerify;
	
	private String boardLogo;

	/**
	 * @return boardLogo
	 */
	public String getBoardLogo() {
		return boardLogo;
	}

	/**
	 * @param boardLogo 要设置的 boardLogo
	 */
	public void setBoardLogo(String boardLogo) {
		this.boardLogo = boardLogo;
	}

	//bi-directional many-to-one association to BlogLog
	@OneToMany(mappedBy="board",cascade=CascadeType.ALL)
	private List<BlogLog> blogLogs;

	//bi-directional many-to-one association to ForumPost
	@OneToMany(mappedBy="board",cascade=CascadeType.ALL)
	private List<ForumPost> forumPosts;

	//bi-directional many-to-one association to Label
	@OneToMany(mappedBy="board",cascade=CascadeType.ALL)
	private List<Label> labels;

	//bi-directional many-to-one association to MasterApply
	@OneToMany(mappedBy="board",cascade=CascadeType.ALL)
	private List<MasterApply> masterApplies;

	//bi-directional many-to-one association to Master
	@OneToMany(mappedBy="board" ,cascade=CascadeType.ALL)
	private List<Master> masters;

	//bi-directional many-to-one association to Question
	@OneToMany(mappedBy="board"	,cascade=CascadeType.ALL)
	private List<Question> questions;

	//bi-directional many-to-one association to WealthBoard
	@OneToMany(mappedBy="board" ,cascade=CascadeType.ALL)
	private List<WealthBoard> wealthBoards;

	public Board() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBoardDesc() {
		return this.boardDesc;
	}

	public void setBoardDesc(String boardDesc) {
		this.boardDesc = boardDesc;
	}

	public String getBoardName() {
		return this.boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public String getBoardPic() {
		return this.boardPic;
	}

	public void setBoardPic(String boardPic) {
		this.boardPic = boardPic;
	}

	public String getIsVerify() {
		return this.isVerify;
	}

	public void setIsVerify(String isVerify) {
		this.isVerify = isVerify;
	}

	public List<BlogLog> getBlogLogs() {
		return this.blogLogs;
	}

	public void setBlogLogs(List<BlogLog> blogLogs) {
		this.blogLogs = blogLogs;
	}

	public BlogLog addBlogLog(BlogLog blogLog) {
		getBlogLogs().add(blogLog);
		blogLog.setBoard(this);

		return blogLog;
	}

	public BlogLog removeBlogLog(BlogLog blogLog) {
		getBlogLogs().remove(blogLog);
		blogLog.setBoard(null);

		return blogLog;
	}

	public List<ForumPost> getForumPosts() {
		return this.forumPosts;
	}

	public void setForumPosts(List<ForumPost> forumPosts) {
		this.forumPosts = forumPosts;
	}

	public ForumPost addForumPost(ForumPost forumPost) {
		getForumPosts().add(forumPost);
		forumPost.setBoard(this);

		return forumPost;
	}

	public ForumPost removeForumPost(ForumPost forumPost) {
		getForumPosts().remove(forumPost);
		forumPost.setBoard(null);

		return forumPost;
	}

	public List<Label> getLabels() {
		return this.labels;
	}

	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}

	public Label addLabel(Label label) {
		getLabels().add(label);
		label.setBoard(this);

		return label;
	}

	public Label removeLabel(Label label) {
		getLabels().remove(label);
		label.setBoard(null);

		return label;
	}

	public List<MasterApply> getMasterApplies() {
		return this.masterApplies;
	}

	public void setMasterApplies(List<MasterApply> masterApplies) {
		this.masterApplies = masterApplies;
	}

	public MasterApply addMasterApply(MasterApply masterApply) {
		getMasterApplies().add(masterApply);
		masterApply.setBoard(this);

		return masterApply;
	}

	public MasterApply removeMasterApply(MasterApply masterApply) {
		getMasterApplies().remove(masterApply);
		masterApply.setBoard(null);

		return masterApply;
	}

	public List<Master> getMasters() {
		return this.masters;
	}

	public void setMasters(List<Master> masters) {
		this.masters = masters;
	}

	public Master addMaster(Master master) {
		getMasters().add(master);
		master.setBoard(this);

		return master;
	}

	public Master removeMaster(Master master) {
		getMasters().remove(master);
		master.setBoard(null);

		return master;
	}

	public List<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Question addQuestion(Question question) {
		getQuestions().add(question);
		question.setBoard(this);

		return question;
	}

	public Question removeQuestion(Question question) {
		getQuestions().remove(question);
		question.setBoard(null);

		return question;
	}

	public List<WealthBoard> getWealthBoards() {
		return this.wealthBoards;
	}

	public void setWealthBoards(List<WealthBoard> wealthBoards) {
		this.wealthBoards = wealthBoards;
	}

	public WealthBoard addWealthBoard(WealthBoard wealthBoard) {
		getWealthBoards().add(wealthBoard);
		wealthBoard.setBoard(this);

		return wealthBoard;
	}

	public WealthBoard removeWealthBoard(WealthBoard wealthBoard) {
		getWealthBoards().remove(wealthBoard);
		wealthBoard.setBoard(null);

		return wealthBoard;
	}

}