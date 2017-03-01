/**
 * 
 */
package com.bbsBlog.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bbsBlog.dao.AuditDao;
import com.bbsBlog.entity.Audit;

/**
 * @author Robust
 *
 * @date 2014年7月28日
 *
 */
@Repository("auditDao")
public class AuditDaoImpl implements AuditDao {

	@Resource
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.AuditDao#saveAduit(com.bbsBlog.entity.Audit)
	 */
	@Override
	public void saveAduit(Audit audit) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.save(audit);

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.AuditDao#updateAudit(com.bbsBlog.entity.Audit)
	 */
	@Override
	public void updateAudit(Audit audit) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.update(audit);

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.AuditDao#deleteAudit(long)
	 */
	@Override
	public void deleteAudit(long id) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.delete(hibernateTemplate.get(Audit.class, id));

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.AuditDao#listAudit()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Audit> listAudit() {
		// TODO 自动生成的方法存根
		return this.hibernateTemplate.find("from Audit");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Audit> listAuditByUserInfo(long id) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from Audit a where a.userInfo.id='"+id+"' order by auditTime desc");
	}	
}
