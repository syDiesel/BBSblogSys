/**
 * 
 */
package com.bbsBlog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbsBlog.dao.AttachDownloadDao;
import com.bbsBlog.entity.AttachDownload;

/**
 * @author Robust
 *
 * @date 2014年9月18日
 *
 */
@Repository("attachDownloadDao")
public class AttachDownloadDaoImpl implements AttachDownloadDao {

	@Resource
	private HibernateTemplate hibernateTemplate;
	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.AttachDownloadDao#saveAttachDownload(com.bbsBlog.entity.AttachDownload)
	 * @param attachDownload
	 *
	 * @author Robust
	 * @date 2014年9月18日
	 *
	 */
	@Override
	public void saveAttachDownload(AttachDownload attachDownload) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.save(attachDownload);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.AttachDownloadDao#updateAttachDownload(com.bbsBlog.entity.AttachDownload)
	 * @param attachDownload
	 *
	 * @author Robust
	 * @date 2014年9月18日
	 *
	 */
	@Override
	public void updateAttachDownload(AttachDownload attachDownload) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.update(attachDownload);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.AttachDownloadDao#deleteAttachDownload(long)
	 * @param id
	 *
	 * @author Robust
	 * @date 2014年9月18日
	 *
	 */
	@Override
	public void deleteAttachDownload(long id) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.delete(this.hibernateTemplate.get(AttachDownload.class, id));
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.AttachDownloadDao#listAttachDownloadBy(java.lang.String)
	 * @param sql
	 * @return
	 *
	 * @author Robust
	 * @date 2014年9月22日
	 *
	 */
	@Override
	public List<AttachDownload> listAttachDownloadBy(String sql) {
		// TODO 自动生成的方法存根
		return this.hibernateTemplate.find(sql);
	}
	
	
}
