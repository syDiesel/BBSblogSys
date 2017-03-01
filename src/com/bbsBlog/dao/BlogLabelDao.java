/**
 * 
 */
package com.bbsBlog.dao;

import java.util.List;

import com.bbsBlog.entity.BlogLabel;

/**
 * @author Robust
 *
 * @date 2014年8月20日
 *
 */
public interface BlogLabelDao {
	public void saveBlogLabel(BlogLabel blogLabel);

	public void updateBlogLabel(BlogLabel blogLabel);

	public void deleteBlogLabel(long id);

	public List<BlogLabel> listBlogLabel();

	public List<BlogLabel> listBlogLabelByLog(long id);

	public List<BlogLabel> listBlogLabelByLabel(long id);

	public int listCount(String queryCountHql);
}
