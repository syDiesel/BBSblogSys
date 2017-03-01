/**
 * 
 */
package com.bbsBlog.service;

import java.util.List;

import com.bbsBlog.entity.UserAlbumPhoto;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月30日
 *
 */
public interface UserAlbumPhotoService {
	
	public void saveUserAlbumPhoto(UserAlbumPhoto uap);

	public void updateUserAlbumPhoto(UserAlbumPhoto uap);

	public void delete(long id);

	public List<UserAlbumPhoto> listUserAlbumPhoto();
	
	public List<UserAlbumPhoto> findByUserAlbumId(long id);
	
	public List<UserAlbumPhoto> findByPhotoId(long id);
	
	public List<UserAlbumPhoto> listZzzm();
	
	public List<UserAlbumPhoto> listZzzmByRoot(String id);
	
	public List<UserAlbumPhoto> listZzzmByAlbumAndRoot(long id);
	
	public PageModel listPhotoByAlbum(int offset, int pageSize, long albumId);
	
	public List<UserAlbumPhoto> listByAlbumNameAndRoot(String albumName,long id);

	public List<UserAlbumPhoto> listBySql(String sql);
}