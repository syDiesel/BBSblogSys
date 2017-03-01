/**
 * 
 */
package com.bbsBlog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bbsBlog.dao.UserUpHisDao;
import com.bbsBlog.entity.UserUpHi;

/**
 * @author Robust
 *
 * @date 2014年9月16日
 *
 */
@Repository("userUpHisDao")
public class UserUpHisDaoImpl implements UserUpHisDao {

	@Resource
	private HibernateTemplate hibernateTemplate;

	/**
	 * @return hibernateTemplate
	 */
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	/**
	 * @param hibernateTemplate
	 *            要设置的 hibernateTemplate
	 */
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.dao.UserUpHisDao#saveUserUpHis(com.bbsBlog.entity.UserUpHi)
	 * 
	 * @param userUpHi
	 * 
	 * @author Robust
	 * 
	 * @date 2014年9月16日
	 */
	@Override
	public void saveUserUpHis(UserUpHi userUpHi) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.save(userUpHi);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.UserUpHisDao#listUserUpHiByUserAndBlog(long, long)
	 * 
	 * @param userId
	 * 
	 * @param blogId
	 * 
	 * @return
	 * 
	 * @author Robust
	 * 
	 * @date 2014年9月16日
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UserUpHi> listUserUpHiByUserAndBlog(long userId, long blogId) {
		// TODO 自动生成的方法存根
		String sql = "from UserUpHi where userInfo.id='" + userId
				+ "' and blogLog.id='" + blogId + "'";
		List<UserUpHi> list = this.hibernateTemplate.find(sql);
		return list;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.UserUpHisDao#listUserUpHiByBlog(long)
	 * 
	 * @param blogId
	 * 
	 * @return
	 * 
	 * @author Robust
	 * 
	 * @date 2014年9月16日
	 */
	@Override
	public List<UserUpHi> listUserUpHiByBlog(long blogId) {
		// TODO 自动生成的方法存根
		String sql = "from UserUpHi where blogLog.blog.id='" + blogId + "'";
		List<UserUpHi> list = this.hibernateTemplate.find(sql);
		return list;
	}

}
