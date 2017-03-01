/**
 * 
 */
package com.bbsBlog.service;

import java.util.List;

import com.bbsBlog.entity.Role;

/**
 * @author Robust
 *
 * @date 2014年7月30日
 *
 */
public interface RoleService {

	public void saveRole(Role role);

	public void updateRole(Role role);

	public void delete(long id);

	public List<Role> listRole();
	
	public Role listRoleById(long id);
}