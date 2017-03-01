package com.bbsBlog.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the PostStatus database table.
 * 
 */
@Entity
@NamedQuery(name="PostStatus.findAll", query="SELECT p FROM PostStatus p")
public class PostStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String status;

	//bi-directional many-to-one association to ForumPost
	@OneToMany(mappedBy="postStatus")
	private List<ForumPost> forumPosts;

	//bi-directional many-to-one association to ForumReply
	@OneToMany(mappedBy="postStatus")
	private List<ForumReply> forumReplies;

	public PostStatus() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ForumPost> getForumPosts() {
		return this.forumPosts;
	}

	public void setForumPosts(List<ForumPost> forumPosts) {
		this.forumPosts = forumPosts;
	}

	public ForumPost addForumPost(ForumPost forumPost) {
		getForumPosts().add(forumPost);
		forumPost.setPostStatus(this);

		return forumPost;
	}

	public ForumPost removeForumPost(ForumPost forumPost) {
		getForumPosts().remove(forumPost);
		forumPost.setPostStatus(null);

		return forumPost;
	}

	public List<ForumReply> getForumReplies() {
		return this.forumReplies;
	}

	public void setForumReplies(List<ForumReply> forumReplies) {
		this.forumReplies = forumReplies;
	}

	public ForumReply addForumReply(ForumReply forumReply) {
		getForumReplies().add(forumReply);
		forumReply.setPostStatus(this);

		return forumReply;
	}

	public ForumReply removeForumReply(ForumReply forumReply) {
		getForumReplies().remove(forumReply);
		forumReply.setPostStatus(null);

		return forumReply;
	}

}