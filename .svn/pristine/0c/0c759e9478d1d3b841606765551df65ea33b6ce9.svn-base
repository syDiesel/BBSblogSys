/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.UserUpHisDao;
import com.bbsBlog.entity.UserUpHi;
import com.bbsBlog.service.UserUpHisService;

/**
 * @author Robust
 *
 * @date 2014年9月16日
 *
 */
@Service("userUpHisService")
public class UserUpHisServieImpl implements UserUpHisService {

	
	@Resource
	private UserUpHisDao userUpHisDao;
	/* （非 Javadoc）
	 * @see com.bbsBlog.service.UserUpHisService#saveUserUpHis(com.bbsBlog.entity.UserUpHi)
	 * @param userUpHi
	 *
	 * @author Robust
	 * @date 2014年9月16日
	 *
	 */
	@Override
	public void saveUserUpHis(UserUpHi userUpHi) {
		// TODO 自动生成的方法存根
			this.userUpHisDao.saveUserUpHis(userUpHi);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.UserUpHisService#listUserUpHiByUserAndBlog(long, long)
	 * @param userId
	 * @param blogId
	 * @return
	 *
	 * @author Robust
	 * @date 2014年9月16日
	 *
	 */
	@Override
	public List<UserUpHi> listUserUpHiByUserAndBlog(long userId, long blogId) {
		// TODO 自动生成的方法存根
		return this.userUpHisDao.listUserUpHiByUserAndBlog(userId, blogId);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.UserUpHisService#listUserUpHiByBlog(long)
	 * @param blogId
	 * @return
	 *
	 * @author Robust
	 * @date 2014年9月16日
	 *
	 */
	@Override
	public List<UserUpHi> listUserUpHiByBlog(long blogId) {
		// TODO 自动生成的方法存根
		return this.userUpHisDao.listUserUpHiByBlog(blogId);
	}

}
