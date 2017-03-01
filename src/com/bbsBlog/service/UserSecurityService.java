/**
 * 
 */
package com.bbsBlog.service;

import java.util.List;

import com.bbsBlog.entity.UserSecurity;

/**
 * @author Robust
 *
 * @date 2014年7月30日
 *
 */
public interface UserSecurityService {
	
	public void saveUserSecurity(UserSecurity secruity);

	public void updateUserSecurity(UserSecurity secruity);

	public void deleteUserSecurity(long id);

	public List<UserSecurity> listUserSecurityByUserId(long id);
}
