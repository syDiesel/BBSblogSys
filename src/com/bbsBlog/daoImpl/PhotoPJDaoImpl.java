/**
 * 
 */
package com.bbsBlog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.bbsBlog.dao.PhotoPJDao;
import com.bbsBlog.entity.PhotoPJ;

/**
 * @author Robust
 *
 * @date 2014年10月25日
 *
 */
@Repository("photoPJDao")
public class PhotoPJDaoImpl extends HibernateDaoSupport implements PhotoPJDao {
	@Resource
	public void setSessionFacotry(SessionFactory sessionFacotry) {
		super.setSessionFactory(sessionFacotry);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.PhotoPJDao#savePhotoPj(com.bbsBlog.entity.PhotoPJ)
	 * 
	 * @param photoPj
	 * 
	 * @author Robust
	 * 
	 * @date 2014年10月25日
	 */
	@Override
	public void savePhotoPj(PhotoPJ photoPj) {
		// TODO 自动生成的方法存根
		this.getHibernateTemplate().save(photoPj);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.PhotoPJDao#findPhotoPjByUserAndPhoto(long, long)
	 * 
	 * @param userId
	 * 
	 * @param photoId
	 * 
	 * @author Robust
	 * 
	 * @date 2014年10月25日
	 */
	@Override
	public List<PhotoPJ> findPhotoPjByUserAndPhoto(long userId, long photoId) {
		// TODO 自动生成的方法存根
		return this.getHibernateTemplate().find(
				"from PhotoPJ where userInfo.id='" + userId
						+ "' and userAlbumPhoto.id='" + photoId + "'");
		
	}

}
