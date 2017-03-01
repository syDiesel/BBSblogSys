package com.bbsBlog.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ForumReply database table.
 * 
 */
@Entity
@NamedQuery(name="ForumReply.findAll", query="SELECT f FROM ForumReply f")
public class ForumReply implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String down;

	private String normal;

	@Column(name="process_cause")
	private String processCause;

	@Lob
	@Column(name="process_his")
	private String processHis;

	@Column(name="process_time")
	private String processTime;

	@Column(name="process_user")
	private String processUser;

	@Lob
	@Column(name="reply_content")
	private String replyContent;

	@Column(name="reply_time")
	private String replyTime;

	private String up;

	//bi-directional many-to-one association to ForumPost
	@ManyToOne
	@JoinColumn(name="post_id")
	private ForumPost forumPost;

	//bi-directional many-to-one association to PostStatus
	@ManyToOne
	@JoinColumn(name="status_id")
	private PostStatus postStatus;

	//bi-directional many-to-one association to UserInfo
	@ManyToOne
	@JoinColumn(name="UserInfo_id")
	private UserInfo userInfo;

	public ForumReply() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDown() {
		return this.down;
	}

	public void setDown(String down) {
		this.down = down;
	}

	public String getNormal() {
		return this.normal;
	}

	public void setNormal(String normal) {
		this.normal = normal;
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

	public String getReplyContent() {
		return this.replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyTime() {
		return this.replyTime;
	}

	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}

	public String getUp() {
		return this.up;
	}

	public void setUp(String up) {
		this.up = up;
	}

	public ForumPost getForumPost() {
		return this.forumPost;
	}

	public void setForumPost(ForumPost forumPost) {
		this.forumPost = forumPost;
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

}