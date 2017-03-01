/**
 * 
 */
package com.bbsBlog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bbsBlog.dao.UserSecurityDao;
import com.bbsBlog.entity.UserSecurity;

/**
 * @author Robust
 *
 * @date 2014年7月28日
 *
 */
@Repository("userSecurityDao")
public class UserSecurityDaoImpl implements UserSecurityDao {
	
	@Resource
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.UserSecurityDao#saveUserSecurity(com.bbsBlog.entity.UserSecurity)
	 */
	@Override
	public void saveUserSecurity(UserSecurity secruity) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.save(secruity);

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.UserSecurityDao#updateUserSecurity(com.bbsBlog.entity.UserSecurity)
	 */
	@Override
	public void updateUserSecurity(UserSecurity secruity) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.update(secruity);

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.UserSecurityDao#deleteUserSecurity(long)
	 */
	@Override
	public void deleteUserSecurity(long id) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.delete(this.hibernateTemplate.get(UserSecurity.class, id));

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.UserSecurityDao#listUserSecurity()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UserSecurity> listUserSecurityByUserId(long id) {
		// TODO 自动生成的方法存根
		return this.hibernateTemplate.find("from UserSecurity u where u.userInfo.id="+id);
	}

}
