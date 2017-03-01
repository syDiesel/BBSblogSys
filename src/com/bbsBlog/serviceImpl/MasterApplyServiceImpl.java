/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.MasterApplyDao;
import com.bbsBlog.entity.MasterApply;
import com.bbsBlog.service.MasterApplyService;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年8月11日
 *
 */
@Service("masterApplyService")
public class MasterApplyServiceImpl implements MasterApplyService {

	
	@Resource
	private MasterApplyDao masterApplyDao;
	/**
	 * @return masterApplyDao
	 */
	public MasterApplyDao getMasterApplyDao() {
		return masterApplyDao;
	}

	/**
	 * @param masterApplyDao 要设置的 masterApplyDao
	 */
	public void setMasterApplyDao(MasterApplyDao masterApplyDao) {
		this.masterApplyDao = masterApplyDao;
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.MasterApplyService#saveMasterApply(com.bbsBlog.entity.MasterApply)
	 * @param masterApply
	 *
	 * @author Robust
	 * @date 2014年8月11日
	 *
	 */
	@Override
	public void saveMasterApply(MasterApply masterApply) {
		// TODO 自动生成的方法存根
		this.masterApplyDao.saveMasterApply(masterApply);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.MasterApplyService#updateMasterApply(com.bbsBlog.entity.MasterApply)
	 * @param masterApply
	 *
	 * @author Robust
	 * @date 2014年8月11日
	 *
	 */
	@Override
	public void updateMasterApply(MasterApply masterApply) {
		// TODO 自动生成的方法存根
		this.masterApplyDao.updateMasterApply(masterApply);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.MasterApplyService#deleteMasterApply(long)
	 * @param id
	 *
	 * @author Robust
	 * @date 2014年8月11日
	 *
	 */
	@Override
	public void deleteMasterApply(long id) {
		// TODO 自动生成的方法存根
		this.masterApplyDao.deleteMasterApply(id);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.MasterApplyService#listMasterApplyById(long)
	 * @param id
	 * @return
	 *
	 * @author Robust
	 * @date 2014年8月11日
	 *
	 */
	@Override
	public MasterApply listMasterApplyById(long id) {
		// TODO 自动生成的方法存根
		return this.masterApplyDao.listMasterApplyById(id);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.MasterApplyService#listMasterApply()
	 * @return
	 *
	 * @author Robust
	 * @date 2014年8月11日
	 *
	 */
	@Override
	public List<MasterApply> listMasterApply() {
		// TODO 自动生成的方法存根
		return this.masterApplyDao.listMasterApply();
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.MasterApplyService#listMasterApply(int, int)
	 * @param offset
	 * @param pageSize
	 * @return
	 *
	 * @author Robust
	 * @date 2014年8月11日
	 *
	 */
	@Override
	public PageModel listMasterApply(int offset, int pageSize) {
		// TODO 自动生成的方法存根
		return this.masterApplyDao.listMasterApply(offset, pageSize);
	}

}
