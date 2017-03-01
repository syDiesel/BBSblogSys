package com.bbsBlog.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the ForumPost database table.
 * 
 */
@Entity
@NamedQuery(name="ForumPost.findAll", query="SELECT f FROM ForumPost f")
public class ForumPost implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String isTop;

	private String isWell;

	private String keywordA;

	private String keywordB;

	private String keywordC;
	
	private String firstImg;

	public String getFirstImg() {
		return firstImg;
	}

	public void setFirstImg(String firstImg) {
		this.firstImg = firstImg;
	}

	@Lob
	@Column(name="post_content")
	private String postContent;

	@Column(name="post_count")
	private String postCount;

	@Column(name="post_date")
	private String postDate;

	@Column(name="post_type")
	private String postType;

	@Column(name="process_cause")
	private String processCause;

	@Lob
	@Column(name="process_his")
	private String processHis;

	@Column(name="process_time")
	private String processTime;

	@Column(name="process_user")
	private String processUser;

	@Column(name="reply_access")
	private String replyAccess;

	@Column(name="reply_count")
	private String replyCount;

	@Column(name="reply_time")
	private String replyTime;

	private String subject;

	//bi-directional many-to-one association to ForumLabel
	@OneToMany(mappedBy="forumPost")
	private List<ForumLabel> forumLabels;

	//bi-directional many-to-one association to Board
	@ManyToOne
	@JoinColumn(name="boa_id")
	private Board board;

	//bi-directional many-to-one association to PostStatus
	@ManyToOne
	@JoinColumn(name="status_id")
	private PostStatus postStatus;

	//bi-directional many-to-one association to UserInfo
	@ManyToOne
	@JoinColumn(name="UserInfo_id")
	private UserInfo userInfo;

	//bi-directional many-to-one association to ForumReply
	@OneToMany(mappedBy="forumPost",cascade=CascadeType.ALL)
	private List<ForumReply> forumReplies;

	//bi-directional many-to-one association to ForumTP
	@OneToMany(mappedBy="forumPost",cascade=CascadeType.ALL)
	private List<ForumTP> forumTps;

	//bi-directional many-to-one association to ForumUpHi
	@OneToMany(mappedBy="forumPost",cascade=CascadeType.ALL)
	private List<ForumUpHi> forumUpHis;

	public ForumPost() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIsTop() {
		return this.isTop;
	}

	public void setIsTop(String isTop) {
		this.isTop = isTop;
	}

	public String getIsWell() {
		return this.isWell;
	}

	public void setIsWell(String isWell) {
		this.isWell = isWell;
	}

	public String getKeywordA() {
		return this.keywordA;
	}

	public void setKeywordA(String keywordA) {
		this.keywordA = keywordA;
	}

	public String getKeywordB() {
		return this.keywordB;
	}

	public void setKeywordB(String keywordB) {
		this.keywordB = keywordB;
	}

	public String getKeywordC() {
		return this.keywordC;
	}

	public void setKeywordC(String keywordC) {
		this.keywordC = keywordC;
	}

	public String getPostContent() {
		return this.postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}

	public String getPostCount() {
		return this.postCount;
	}

	public void setPostCount(String postCount) {
		this.postCount = postCount;
	}

	public String getPostDate() {
		return this.postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public String getPostType() {
		return this.postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

	public String getProcessCause() {
		return this.processCause;
	}

	public void setProcessCause(String processCause) {
		this.processCause = processCause;
	}

	public String getProcessHis() {
		return this.processHis;
	}

	public void setProcessHis(String processHis) {
		this.processHis = processHis;
	}

	public String getProcessTime() {
		return this.processTime;
	}

	public void setProcessTime(String processTime) {
		this.processTime = processTime;
	}

	public String getProcessUser() {
		return this.processUser;
	}

	public void setProcessUser(String processUser) {
		this.processUser = processUser;
	}

	public String getReplyAccess() {
		return this.replyAccess;
	}

	public void setReplyAccess(String replyAccess) {
		this.replyAccess = replyAccess;
	}

	public String getReplyCount() {
		return this.replyCount;
	}

	public void setReplyCount(String replyCount) {
		this.replyCount = replyCount;
	}

	public String getReplyTime() {
		return this.replyTime;
	}

	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<ForumLabel> getForumLabels() {
		return this.forumLabels;
	}

	public void setForumLabels(List<ForumLabel> forumLabels) {
		this.forumLabels = forumLabels;
	}

	public ForumLabel addForumLabel(ForumLabel forumLabel) {
		getForumLabels().add(forumLabel);
		forumLabel.setForumPost(this);

		return forumLabel;
	}

	public ForumLabel removeForumLabel(ForumLabel forumLabel) {
		getForumLabels().remove(forumLabel);
		forumLabel.setForumPost(null);

		return forumLabel;
	}

	public Board getBoard() {
		return this.board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public PostStatus getPostStatus() {
		return this.postStatus;
	}

	public void setPostStatus(PostStatus postStatus) {
		this.postStatus = postStatus;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public List<ForumReply> getForumReplies() {
		return this.forumReplies;
	}

	public void setForumReplies(List<ForumReply> forumReplies) {
		this.forumReplies = forumReplies;
	}

	public ForumReply addForumReply(ForumReply forumReply) {
		getForumReplies().add(forumReply);
		forumReply.setForumPost(this);

		return forumReply;
	}

	public ForumReply removeForumReply(ForumReply forumReply) {
		getForumReplies().remove(forumReply);
		forumReply.setForumPost(null);

		return forumReply;
	}

	public List<ForumTP> getForumTps() {
		return this.forumTps;
	}

	public void setForumTps(List<ForumTP> forumTps) {
		this.forumTps = forumTps;
	}

	public ForumTP addForumTp(ForumTP forumTp) {
		getForumTps().add(forumTp);
		forumTp.setForumPost(this);

		return forumTp;
	}

	public ForumTP removeForumTp(ForumTP forumTp) {
		getForumTps().remove(forumTp);
		forumTp.setForumPost(null);

		return forumTp;
	}

	public List<ForumUpHi> getForumUpHis() {
		return this.forumUpHis;
	}

	public void setForumUpHis(List<ForumUpHi> forumUpHis) {
		this.forumUpHis = forumUpHis;
	}

	public ForumUpHi addForumUpHi(ForumUpHi forumUpHi) {
		getForumUpHis().add(forumUpHi);
		forumUpHi.setForumPost(this);

		return forumUpHi;
	}

	public ForumUpHi removeForumUpHi(ForumUpHi forumUpHi) {
		getForumUpHis().remove(forumUpHi);
		forumUpHi.setForumPost(null);

		return forumUpHi;
	}

}