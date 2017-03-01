/**
 * 
 */
package com.bbsBlog.dao;

import java.util.List;

import com.bbsBlog.entity.BlogStatus;

/**
 * @author Robust
 *
 * @date 2014年7月26日
 *
 */
public interface BlogStatusDao {
	
	public void saveBlogStatus(BlogStatus blogStatus);

	public void updateBlogStatus(BlogStatus blogStatus);

	public void deleteBlogStatus(long id);

	public List<BlogStatus> listBlogStatus();
	
	public BlogStatus listBlogStatusById(long id);

}
