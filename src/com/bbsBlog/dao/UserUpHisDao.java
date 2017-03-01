/**
 * 
 */
package com.bbsBlog.dao;

import java.util.List;

import com.bbsBlog.entity.UserUpHi;

/**
 * @author Robust
 *
 * @date 2014年9月16日
 *
 */
public interface UserUpHisDao {
	
	public void saveUserUpHis(UserUpHi userUpHi);
	
	public List<UserUpHi> listUserUpHiByUserAndBlog(long userId,long blogId);
	
	public List<UserUpHi> listUserUpHiByBlog(long blogId);
}
