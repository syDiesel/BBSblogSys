/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.PersonalInfoDao;
import com.bbsBlog.entity.PersonalInfo;
import com.bbsBlog.service.PersonalInfoService;

/**
 * @author Robust
 *
 * @date 2014年7月30日
 *
 */
@Service("PersonalInfoService")
public class PersonalInfoServiceImpl implements PersonalInfoService {
	
	@Resource
	private PersonalInfoDao PersonalInfoDao;
	
	/**
	 * @return PersonalInfoDao
	 */
	public PersonalInfoDao getPersonalInfoDao() {
		return PersonalInfoDao;
	}

	/**
	 * @param PersonalInfoDao 要设置的 PersonalInfoDao
	 */
	public void setPersonalInfoDao(PersonalInfoDao PersonalInfoDao) {
		this.PersonalInfoDao = PersonalInfoDao;
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.PersonalInfoService#savePersonalInfo(com.bbsBlog.entity.PersonalInfo)
	 */
	@Override
	public void savePersonalInfo(PersonalInfo per) {
		// TODO 自动生成的方法存根
		this.PersonalInfoDao.savePersonalInfo(per);

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.PersonalInfoService#updatePersonalInfo(com.bbsBlog.entity.PersonalInfo)
	 */
	@Override
	public void updatePersonalInfo(PersonalInfo per) {
		// TODO 自动生成的方法存根
		this.PersonalInfoDao.updatePersonalInfo(per);

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.PersonalInfoService#deletePersonalInfo(long)
	 */
	@Override
	public void deletePersonalInfo(long id) {
		// TODO 自动生成的方法存根
		this.PersonalInfoDao.deletePersonalInfo(id);
	
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.PersonalInfoService#listPersonalInfo()
	 */
	@Override
	public List<PersonalInfo> listPersonalInfo() {
		// TODO 自动生成的方法存根
		return this.PersonalInfoDao.listPersonalInfo();
	}
	
	public PersonalInfo findById(long id){
		return this.PersonalInfoDao.findById(id);
		
	}

}
