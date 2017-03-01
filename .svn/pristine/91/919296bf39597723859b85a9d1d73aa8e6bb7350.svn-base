/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.AuditDao;
import com.bbsBlog.entity.Audit;
import com.bbsBlog.service.AuditService;

/**
 * @author Robust
 *
 * @date 2014年7月30日
 *
 */
@Service("auditService")
public class AuditServiceImpl implements AuditService {

	
	@Resource
	private AuditDao auditDao;
	/**
	 * @return auditDao
	 */
	public AuditDao getAuditDao() {
		return auditDao;
	}

	/**
	 * @param auditDao 要设置的 auditDao
	 */
	public void setAuditDao(AuditDao auditDao) {
		this.auditDao = auditDao;
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.AuditService#saveAduit(com.bbsBlog.entity.Audit)
	 */
	@Override
	public void saveAduit(Audit audit) {
		// TODO 自动生成的方法存根
		this.auditDao.saveAduit(audit);

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.AuditService#updateAudit(com.bbsBlog.entity.Audit)
	 */
	@Override
	public void updateAudit(Audit audit) {
		// TODO 自动生成的方法存根
		this.auditDao.updateAudit(audit);

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.AuditService#deleteAudit(long)
	 */
	@Override
	public void deleteAudit(long id) {
		// TODO 自动生成的方法存根
		this.auditDao.deleteAudit(id);

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.AuditService#listAudit()
	 */
	@Override
	public List<Audit> listAudit() {
		// TODO 自动生成的方法存根
		return this.auditDao.listAudit();
	}

	@Override
	public List<Audit> listAuditByUserInfo(long id) {
		// TODO Auto-generated method stub
		return this.auditDao.listAuditByUserInfo(id);
	}

}
