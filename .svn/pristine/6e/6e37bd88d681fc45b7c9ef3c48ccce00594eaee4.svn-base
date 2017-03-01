/**
 * 
 */
package com.bbsBlog.dao;

import java.util.List;

import com.bbsBlog.entity.BlogHI;
import com.bbsBlog.entity.UserInfo;

/**
 * @author Robust
 *
 * @date 2014年9月17日
 *
 */
public interface BlogHiDao {
	public void saveBlogHi(BlogHI blogHi);

	public void deleteBlogHi(long id);

	public void updateBlogHi(BlogHI blogHi);
	
	public List<BlogHI> listBlogHiByUserAndBlog(long userInfoId,long blogId,String time);
	
	public UserInfo listUserByBlogLog(long id);
	
	public int listCount(String queryCountHql);
}
