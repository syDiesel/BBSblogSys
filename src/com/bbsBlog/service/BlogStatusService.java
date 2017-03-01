/**
 * 
 */
package com.bbsBlog.service;

import java.util.List;

import com.bbsBlog.entity.BlogStatus;

/**
 * @author Robust
 *
 * @date 2014年7月29日
 *
 */
public interface BlogStatusService {

	public void saveBlogStatus(BlogStatus blogStatus);

	public void updateBlogStatus(BlogStatus blogStatus);

	public void deleteBlogStatus(long id);

	public List<BlogStatus> listBlogStatus();
	
	public BlogStatus listBlogStatusById(long id);
}
