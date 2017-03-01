/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.UserAlbumPhotoDao;
import com.bbsBlog.entity.UserAlbumPhoto;
import com.bbsBlog.service.UserAlbumPhotoService;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月30日
 *
 */
@Service("userAlbumPhotoService")
public class UserAlbumPhotoServiceImpl implements UserAlbumPhotoService {

	@Resource
	private UserAlbumPhotoDao userAlbumPhotoDao;

	/**
	 * @return userAlbumPhotoDao
	 */
	public UserAlbumPhotoDao getUserAlbumPhotoDao() {
		return userAlbumPhotoDao;
	}

	/**
	 * @param userAlbumPhotoDao
	 *            要设置的 userAlbumPhotoDao
	 */
	public void setUserAlbumPhotoDao(UserAlbumPhotoDao userAlbumPhotoDao) {
		this.userAlbumPhotoDao = userAlbumPhotoDao;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.UserAlbumPhotoService#saveUserAlbumPhoto(com.bbsBlog
	 * .entity.UserAlbumPhoto)
	 */
	@Override
	public void saveUserAlbumPhoto(UserAlbumPhoto uap) {
		// TODO 自动生成的方法存根
		this.userAlbumPhotoDao.saveUserAlbumPhoto(uap);

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.UserAlbumPhotoService#updateUserAlbumPhoto(com.bbsBlog
	 * .entity.UserAlbumPhoto)
	 */
	@Override
	public void updateUserAlbumPhoto(UserAlbumPhoto uap) {
		// TODO 自动生成的方法存根
		this.userAlbumPhotoDao.updateUserAlbumPhoto(uap);

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.UserAlbumPhotoService#delete(long)
	 */
	@Override
	public void delete(long id) {
		// TODO 自动生成的方法存根
		this.userAlbumPhotoDao.delete(id);

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.UserAlbumPhotoService#listUserAlbumPhoto()
	 */
	@Override
	public List<UserAlbumPhoto> listUserAlbumPhoto() {
		// TODO 自动生成的方法存根
		return this.userAlbumPhotoDao.listUserAlbumPhoto();
	}

	@Override
	public List<UserAlbumPhoto> findByUserAlbumId(long id) {
		// TODO Auto-generated method stub
		return this.userAlbumPhotoDao.findByUserAlbumId(id);
	}

	@Override
	public List<UserAlbumPhoto> findByPhotoId(long id) {
		// TODO Auto-generated method stub
		return this.userAlbumPhotoDao.findByPhotoId(id);
	}

	@Override
	public List<UserAlbumPhoto> listZzzm() {
		// TODO Auto-generated method stub
		return this.userAlbumPhotoDao.listZzzm();
	}

	@Override
	public List<UserAlbumPhoto> listZzzmByRoot(String id) {
		// TODO Auto-generated method stub
		return this.userAlbumPhotoDao.listZzzmByRoot(id);
	}

	@Override
	public List<UserAlbumPhoto> listZzzmByAlbumAndRoot(long id) {
		// TODO Auto-generated method stub
		return this.userAlbumPhotoDao.listZzzmByAlbumAndRoot(id);
	}

	@Override
	public PageModel listPhotoByAlbum(int offset, int pageSize, long albumId) {
		// TODO Auto-generated method stub
		return this.userAlbumPhotoDao.listPhotoByAlbum(offset,pageSize,albumId);
	}

	@Override
	public List<UserAlbumPhoto> listByAlbumNameAndRoot(String albuName,long id) {
		// TODO Auto-generated method stub
		return this.userAlbumPhotoDao.listByAlbumNameAndRoot(albuName,id);
	}

	@Override
	public List<UserAlbumPhoto> listBySql(String sql) {
		// TODO Auto-generated method stub
		return this.userAlbumPhotoDao.listBySql(sql);
	}

}
