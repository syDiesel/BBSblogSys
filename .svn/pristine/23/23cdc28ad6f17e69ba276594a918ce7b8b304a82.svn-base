/**
 * 
 */
package com.bbsBlog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bbsBlog.dao.UserAlbumDao;
import com.bbsBlog.entity.UserAlbum;

/**
 * @author Robust
 *
 * @date 2014年7月28日
 *
 */
@Repository("userAlbumDao")
public class UserAlbumDaoImpl implements UserAlbumDao {
	
	@Resource
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.UserAlbumDao#saveUserAlbum(com.bbsBlog.entity.UserAlbum)
	 */
	@Override
	public void saveUserAlbum(UserAlbum album) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.save(album);

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.UserAlbumDao#updateUserAlbum(com.bbsBlog.entity.UserAlbum)
	 */
	@Override
	public void updateUserAlbum(UserAlbum album) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.update(album);

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.UserAlbumDao#delete(long)
	 */
	@Override
	public void delete(long id) {
		// TODO 自动生成的方法存根
		this.hibernateTemplate.delete(this.hibernateTemplate.get(UserAlbum.class,id));

	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.dao.UserAlbumDao#listUserAlbum()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UserAlbum> listUserAlbum() {
		// TODO 自动生成的方法存根
		return this.hibernateTemplate.find("from UserAlbum");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAlbum> findByUserInfoId(long id) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from UserAlbum where userInfo.id='"+id+"'");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAlbum> listUserAlbumByAlbumName(String albumName) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from UserAlbum where albumName='"+albumName+"'");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAlbum> listUserAlbumById(long id) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from UserAlbum where id='"+id+"'");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAlbum> findByUserAndId(long userId,String albumName) {
		// TODO Auto-generated method stub
		return  this.hibernateTemplate.find("from UserAlbum where userInfo.id='"+userId+"' and albumName='"+albumName+"'");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAlbum> listByUserAndNoName(long id, String albumName) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from UserAlbum where userInfo.id='"+id+"' and albumName <> '"+albumName+"'");
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkExistByUserAndAlbumName(long id, String albumName) {
		// TODO Auto-generated method stub
		List<UserAlbum> listAlbum = this.hibernateTemplate.find("from UserAlbum where userInfo.id = '"+id+"' and " +
				"albumName = '"+albumName+"'");
		if (listAlbum.size() > 0)
			return true;
		else
			return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkExistById(long id) {
		// TODO Auto-generated method stub
		List<UserAlbum> listAlbum = this.hibernateTemplate.find("from UserAlbum where id='"+id+"'");
		if (listAlbum.size() > 0)
			return true;
		else
			return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAlbum> listByUserAndAlbumName(long id, String albumName) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from UserAlbum where userInfo.id='"+id+"' and albumName = '"+albumName+"'");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAlbum> listBySql(String sql) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find(sql);
	}

}
