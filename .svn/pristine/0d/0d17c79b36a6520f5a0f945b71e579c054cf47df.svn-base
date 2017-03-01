/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.UserAlbumDao;
import com.bbsBlog.entity.UserAlbum;
import com.bbsBlog.service.UserAlbumService;

/**
 * @author Robust
 *
 * @date 2014年7月30日
 *
 */
@Service("UserAlbumService")
public class UserAlbumServiceImpl implements UserAlbumService {

	@Resource
	private UserAlbumDao userAlbumDao;

	/**
	 * @return UserAlbumDao
	 */
	public UserAlbumDao getUserAlbumDao() {
		return userAlbumDao;
	}

	/**
	 * @param userAlbumDao
	 *            要设置的 UserAlbumDao
	 */
	public void setUserAlbumDao(UserAlbumDao userAlbumDao) {
		this.userAlbumDao = userAlbumDao;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.UserAlbumService#saveUserAlbum(com.bbsBlog.entity
	 * .UserAlbum)
	 */
	@Override
	public void saveUserAlbum(UserAlbum album) {
		// TODO 自动生成的方法存根
		this.userAlbumDao.saveUserAlbum(album);

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.UserAlbumService#updateUserAlbum(com.bbsBlog.entity
	 * .UserAlbum)
	 */
	@Override
	public void updateUserAlbum(UserAlbum album) {
		// TODO 自动生成的方法存根
		this.userAlbumDao.updateUserAlbum(album);

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.UserAlbumService#delete(long)
	 */
	@Override
	public void delete(long id) {
		// TODO 自动生成的方法存根
		this.userAlbumDao.delete(id);

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.UserAlbumService#listUserAlbum()
	 */
	@Override
	public List<UserAlbum> listUserAlbum() {
		// TODO 自动生成的方法存根
		return this.userAlbumDao.listUserAlbum();
	}

	@Override
	public List<UserAlbum> findByUserInfoId(long id) {
		// TODO Auto-generated method stub
		return this.userAlbumDao.findByUserInfoId(id);
	}

	@Override
	public List<UserAlbum> listUserAlbumByAlbumName(String albumName) {
		// TODO Auto-generated method stub
		return this.userAlbumDao.listUserAlbumByAlbumName(albumName);
	}

	@Override
	public List<UserAlbum> listUserAlbumById(long id) {
		// TODO Auto-generated method stub
		return this.userAlbumDao.listUserAlbumById(id);
	}

	@Override
	public List<UserAlbum> findByUserAndId(long userId, String albumName) {
		// TODO Auto-generated method stub
		return this.userAlbumDao.findByUserAndId(userId,albumName);
	}

	@Override
	public List<UserAlbum> listByUserAndNoName(long id, String albumName) {
		// TODO Auto-generated method stub
		return this.userAlbumDao.listByUserAndNoName(id,albumName);
	}

	@Override
	public boolean checkExistByUserAndAlbumName(long id, String albumName) {
		// TODO Auto-generated method stub
		return this.userAlbumDao.checkExistByUserAndAlbumName(id,albumName);
	}

	@Override
	public boolean checkExistById(long id) {
		// TODO Auto-generated method stub
		return this.userAlbumDao.checkExistById(id);
	}

	@Override
	public List<UserAlbum> listByUserAndAlbumName(long id, String albumName) {
		// TODO Auto-generated method stub
		return this.userAlbumDao.listByUserAndAlbumName(id , albumName);
	}

	@Override
	public List<UserAlbum> listBySql(String sql) {
		// TODO Auto-generated method stub
		return this.userAlbumDao.listBySql(sql);
	}

}
