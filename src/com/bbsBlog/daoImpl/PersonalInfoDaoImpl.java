/**
 * 
 */
package com.bbsBlog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bbsBlog.dao.PersonalInfoDao;
import com.bbsBlog.entity.PersonalInfo;

/**
 * @author Robust
 *
 * @date 2014年7月28日
 *
 */
@Repository("personalInfoDao)")
public class PersonalInfoDaoImpl implements PersonalInfoDao {
	
	@Resource
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.PersonalInfoDao#savePersonalInfo(com.bbsBlog.entity.PersonalInfo)
	 */
	@Override
	public void savePersonalInfo(PersonalInfo per) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.save(per);

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.PersonalInfoDao#updatePersonalInfo(com.bbsBlog.entity.PersonalInfo)
	 */
	@Override
	public void updatePersonalInfo(PersonalInfo per) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.update(per);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.PersonalInfoDao#deletePersonalInfo(long)
	 */
	@Override
	public void deletePersonalInfo(long id) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.delete(this.hibernateTemplate.get(PersonalInfo.class, id));

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.PersonalInfoDao#listPersonalInfo()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PersonalInfo> listPersonalInfo() {
		// TODO 自动生成的方法存根
		return this.hibernateTemplate.find("from PersonalInfo");
	}
	
	public PersonalInfo findById(long id){
		return this.hibernateTemplate.get(PersonalInfo.class,id);
		
	}

}
