/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.MasterDao;
import com.bbsBlog.entity.Master;
import com.bbsBlog.service.MasterService;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月30日
 *
 */
@Service("masterService")
public class MasterServiceImpl implements MasterService {

	@Resource
	private MasterDao masterDao;

	/**
	 * @return masterDao
	 */
	public MasterDao getMasterDao() {
		return masterDao;
	}

	/**
	 * @param masterDao
	 *            要设置的 masterDao
	 */
	public void setMasterDao(MasterDao masterDao) {
		this.masterDao = masterDao;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.MasterService#saveMaster(com.bbsBlog.entity.Master)
	 */
	@Override
	public void saveMaster(Master master) {
		// TODO 自动生成的方法存根
		this.masterDao.saveMaster(master);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.MasterService#updateMaster(com.bbsBlog.entity.Master)
	 */
	@Override
	public void updateMaster(Master master) {
		// TODO 自动生成的方法存根
		this.masterDao.updateMaster(master);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.MasterService#deleteMaster(long)
	 */
	@Override
	public void deleteMaster(long id) {
		// TODO 自动生成的方法存根
		this.masterDao.deleteMaster(id);
	}
	
	@Override
	public List<Master> listMaster() {
		// TODO 自动生成的方法存根
		return this.masterDao.listMaster();
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.MasterService#listMaster()
	 */
	@Override
	public PageModel listMaster(int offset, int pageSize) {
		// TODO 自动生成的方法存根
		return this.masterDao.listMaster(offset,pageSize);
	}
	@Override
	public Master listMasterById(long id){
		return this.masterDao.listMasterById(id);
	}
	
	@Override
	public List<Master> listMasterByBoard(long board_id){
	
		// TODO 自动生成的方法存根
		return this.masterDao.listMasterByBoard(board_id);
	}

}
