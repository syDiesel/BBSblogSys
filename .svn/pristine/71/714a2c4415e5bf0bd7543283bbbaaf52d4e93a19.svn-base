package com.bbsBlog.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the BlogStatus database table.
 * 
 */
@Entity
@NamedQuery(name="BlogStatus.findAll", query="SELECT b FROM BlogStatus b")
public class BlogStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private String status;

	//bi-directional many-to-one association to BlogLog
	@OneToMany(mappedBy="blogStatus")
	private List<BlogLog> blogLogs;

	public BlogStatus() {
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

	public List<BlogLog> getBlogLogs() {
		return this.blogLogs;
	}

	public void setBlogLogs(List<BlogLog> blogLogs) {
		this.blogLogs = blogLogs;
	}

	public BlogLog addBlogLog(BlogLog blogLog) {
		getBlogLogs().add(blogLog);
		blogLog.setBlogStatus(this);

		return blogLog;
	}

	public BlogLog removeBlogLog(BlogLog blogLog) {
		getBlogLogs().remove(blogLog);
		blogLog.setBlogStatus(null);

		return blogLog;
	}

}