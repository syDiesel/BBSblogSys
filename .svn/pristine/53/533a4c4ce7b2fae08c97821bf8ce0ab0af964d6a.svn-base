/**
 * 
 */
package com.bbsBlog.service;

import java.util.List;

import com.bbsBlog.entity.UserAlbum;

/**
 * @author Robust
 *
 * @date 2014年7月30日
 *
 */
public interface UserAlbumService {
	
	public void saveUserAlbum(UserAlbum album);

	public void updateUserAlbum(UserAlbum ablum);

	public void delete(long id);

	public List<UserAlbum> listUserAlbum();
	
	public List<UserAlbum> listUserAlbumByAlbumName(String albumName);
	
	public List<UserAlbum> listUserAlbumById(long id);
	
	public List<UserAlbum> findByUserInfoId(long id);
	
	public List<UserAlbum> listBySql(String sql);
	
	public List<UserAlbum> findByUserAndId(long userId,String albumName);
	
	public List<UserAlbum> listByUserAndNoName(long id, String albumName);
	
	public List<UserAlbum> listByUserAndAlbumName(long id , String albumName);
	
	public boolean checkExistByUserAndAlbumName(long id, String albumName);
	
	public boolean checkExistById(long id);
}