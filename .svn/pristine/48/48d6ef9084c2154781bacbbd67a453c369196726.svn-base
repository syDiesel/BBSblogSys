/**
 * 
 */
package com.bbsBlog.service;

import java.util.List;

import com.bbsBlog.entity.Blog;
import com.bbsBlog.entity.UserInfo;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月29日
 *
 */
public interface BlogService {

	public void saveBlog(Blog blog);

	public void updateBlog(Blog blog);

	public void deleteBlog(long id);

	public List<Blog> listBlog();
	
	public PageModel listBlog(int offset,int pageSize);
	
	public List<Blog> listBlogBySql(String sql);
	
	public Blog listBlogById(long id);
	
	public PageModel listBlog(int offset, int pageSize,String queryCountHql,String hql) ;
	
	public List<Blog> findBlogByUserInfo(UserInfo userInfo);
}
