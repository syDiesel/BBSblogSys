/**
 * 
 */
package com.bbsBlog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bbsBlog.dao.AttachStatusDao;
import com.bbsBlog.entity.AttachStatus;

/**
 * @author Robust
 *
 * @date 2014年7月28日
 *
 */
@Repository("attachStatusDao")
public class AttachStatusDaoImpl implements AttachStatusDao {
	
	@Resource
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.AttachStatus#saveAttachStatus(com.bbsBlog.dao.AttachStatus)
	 */
	@Override
	public void saveAttachStatus(AttachStatus attachStatus) {
		// TODO 自动生成的方法存根

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.AttachStatus#updateAttachStatus(com.bbsBlog.dao.AttachStatus)
	 */
	@Override
	public void updateAttachStatus(AttachStatus attachStatus) {
		// TODO 自动生成的方法存根

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.AttachStatus#deleteAttachStatus(long)
	 */
	@Override
	public void deleteAttachStatus(long id) {
		// TODO 自动生成的方法存根

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.AttachStatus#listAttachStatus()
	 */
	@Override
	public List<AttachStatus> listAttachStatus() {
		// TODO 自动生成的方法存根
		return null;
	}

}
