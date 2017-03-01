/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.UserSecurityDao;
import com.bbsBlog.entity.UserSecurity;
import com.bbsBlog.service.UserSecurityService;

/**
 * @author Robust
 *
 * @date 2014年7月30日
 *
 */
@Service("userSecurityService")
public class UserSecurityServiceImpl implements UserSecurityService {

	@Resource
	private UserSecurityDao userSecurityDao;

	/**
	 * @return UserSecurityDao
	 */
	public UserSecurityDao getUserSecurityDao() {
		return userSecurityDao;
	}

	/**
	 * @param userSecurityDao
	 *            要设置的 UserSecurityDao
	 */
	public void setUserSecurityDao(UserSecurityDao userSecurityDao) {
		this.userSecurityDao = userSecurityDao;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.UserSecurityService#saveUserSecurity(com.bbsBlog
	 * .entity.UserSecurity)
	 */
	@Override
	public void saveUserSecurity(UserSecurity secruity) {
		// TODO 自动生成的方法存根
		this.userSecurityDao.saveUserSecurity(secruity);

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.UserSecurityService#updateUserSecurity(com.bbsBlog
	 * .entity.UserSecurity)
	 */
	@Override
	public void updateUserSecurity(UserSecurity secruity) {
		// TODO 自动生成的方法存根
		this.userSecurityDao.updateUserSecurity(secruity);

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.UserSecurityService#deleteUserSecurity(long)
	 */
	@Override
	public void deleteUserSecurity(long id) {
		// TODO 自动生成的方法存根
       this.userSecurityDao.deleteUserSecurity(id);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.UserSecurityService#listUserSecurity()
	 */
	@Override
	public List<UserSecurity> listUserSecurityByUserId(long id) {
		// TODO 自动生成的方法存根
		return this.userSecurityDao.listUserSecurityByUserId(id);
	}

}
