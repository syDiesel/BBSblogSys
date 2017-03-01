package com.bbsBlog.dao;

import java.util.List;

import com.bbsBlog.entity.Notice;

/**
 * 
 * @author 曦风
 *
 * @date 2014-9-14
 *
 * @param 下午9:38:04
 */
public interface NoticeDao {

	public void saveNotice(Notice notice);

	public void updateNotice(Notice notice);

	public void deleteNotice(long id);

	public List<Notice> listNotice();
	
	public Notice findById(long id);
	
}


