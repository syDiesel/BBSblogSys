package com.bbsBlog.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Blog database table.
 * 
 */
@Entity
@NamedQuery(name="Blog.findAll", query="SELECT b FROM Blog b")
public class Blog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String blog_Album;

	@Column(name="blog_desc")
	private String blogDesc;

	@Column(name="blog_name")
	private String blogName;

	@Column(name="blog_up")
	private String blogUp;

	private String visited;

	//bi-directional one-to-one association to UserInfo
	@OneToOne
	@JoinColumn(name="id")
	private UserInfo userInfo;

	//bi-directional many-to-one association to BlogLog
	@OneToMany(mappedBy="blog")
	private List<BlogLog> blogLogs;

	public Blog() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBlog_Album() {
		return this.blog_Album;
	}

	public void setBlog_Album(String blog_Album) {
		this.blog_Album = blog_Album;
	}

	public String getBlogDesc() {
		return this.blogDesc;
	}

	public void setBlogDesc(String blogDesc) {
		this.blogDesc = blogDesc;
	}

	public String getBlogName() {
		return this.blogName;
	}

	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}

	public String getBlogUp() {
		return this.blogUp;
	}

	public void setBlogUp(String blogUp) {
		this.blogUp = blogUp;
	}

	public String getVisited() {
		return this.visited;
	}

	public void setVisited(String visited) {
		this.visited = visited;
	}

	public UserInfo getUserInfo() {
		return this.userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public List<BlogLog> getBlogLogs() {
		return this.blogLogs;
	}

	public void setBlogLogs(List<BlogLog> blogLogs) {
		this.blogLogs = blogLogs;
	}

	public BlogLog addBlogLog(BlogLog blogLog) {
		getBlogLogs().add(blogLog);
		blogLog.setBlog(this);

		return blogLog;
	}

	public BlogLog removeBlogLog(BlogLog blogLog) {
		getBlogLogs().remove(blogLog);
		blogLog.setBlog(null);

		return blogLog;
	}

}