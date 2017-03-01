/**
 * 
 */
package com.bbsBlog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bbsBlog.dao.RoleDao;
import com.bbsBlog.entity.Role;

/**
 * @author Robust
 *
 * @date 2014年7月28日
 *
 */
@Repository("roleDao")
public class RoleDaoImpl implements RoleDao {
	
	@Resource
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.RoleDao#saveRole(com.bbsBlog.entity.Role)
	 */
	@Override
	public void saveRole(Role role) {
		// TODO 自动生成的方法存根

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.RoleDao#updateRole(com.bbsBlog.entity.Role)
	 */
	@Override
	public void updateRole(Role role) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.update(role);
		
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.RoleDao#delete(long)
	 */
	@Override
	public void delete(long id) {
		// TODO 自动生成的方法存根

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.RoleDao#listRole()
	 */
	@Override
	public List<Role> listRole() {
		// TODO 自动生成的方法存根
		return null;
	}
	
	
	@Override
	public Role listRoleById(long id) {
		// TODO 自动生成的方法存根
		return this.hibernateTemplate.get(Role.class, id);
	}
	
	

}
