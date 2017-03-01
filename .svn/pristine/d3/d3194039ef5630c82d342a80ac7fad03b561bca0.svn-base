/**
 * 
 */
package com.bbsBlog.dao;

import java.util.List;

import com.bbsBlog.entity.BlogLog;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月26日
 *
 */
public interface BlogLogDao {

	public void saveBlogLog(BlogLog blogLog);

	public void updateBlogLog(BlogLog blogLog);

	public void deleteBlogLog(long id);

	public List<BlogLog> listBlogLog();

	public PageModel listBloglog(int offset, int pageSize);
	
	public PageModel listBloglogByBlog(int offset, int pageSize,long BlogId);
	
	public BlogLog listBlogLogById(long id);
	
	public List<BlogLog> listBlogLogByKey(String keyword, String lab, String sub, String con);
	
	public List<BlogLog> listBlogLogByTime(String keyword, String lab, String sub, String con);
	
	public List<BlogLog> listBlogByBoard(long board_id);
	
	public List<BlogLog> listBlogLogByBlogId(long id);
	
	public PageModel listBloglogBySQL(int offset, int pageSize, String queryCountHql,String hql);

	public int listCount(String queryCountHql);
	
	public List<BlogLog> listBlogLogBySql(String sql);
 }
