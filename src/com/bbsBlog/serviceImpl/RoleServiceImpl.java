/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.RoleDao;
import com.bbsBlog.entity.Role;
import com.bbsBlog.service.RoleService;

/**
 * @author Robust
 *
 * @date 2014年7月30日
 *
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleDao roleDao;

	/**
	 * @return roleDao
	 */
	public RoleDao getRoleDao() {
		return roleDao;
	}

	/**
	 * @param roleDao
	 *            要设置的 roleDao
	 */
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.RoleService#saveRole(com.bbsBlog.entity.Role)
	 */
	@Override
	public void saveRole(Role role) {
		// TODO 自动生成的方法存根

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.RoleService#updateRole(com.bbsBlog.entity.Role)
	 */
	@Override
	public void updateRole(Role role) {
		// TODO 自动生成的方法存根
		this.roleDao.updateRole(role);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.RoleService#delete(long)
	 */
	@Override
	public void delete(long id) {
		// TODO 自动生成的方法存根

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.RoleService#listRole()
	 */
	@Override
	public List<Role> listRole() {
		// TODO 自动生成的方法存根
		return null;
	}
	
	
	@Override
	public Role listRoleById(long id) {
		// TODO 自动生成的方法存根
		return this.roleDao.listRoleById(id);
	}

}
