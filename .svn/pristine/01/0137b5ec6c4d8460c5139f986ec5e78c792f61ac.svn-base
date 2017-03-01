/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.NoticeDao;
import com.bbsBlog.entity.Notice;
import com.bbsBlog.service.NoticeService;

/**
 * 
 * @author 曦风
 *
 * @date 2014-9-14
 *
 * @param 下午9:41:47
 */
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Resource
	private NoticeDao noticeDao;

	public NoticeDao getNoticeDao() {
		return noticeDao;
	}

	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	
	@Override
	public void saveNotice(Notice notice) {
		// TODO 自动生成的方法存根

		this.noticeDao.saveNotice(notice);
	}

	
	@Override
	public void updateNotice(Notice notice) {
		// TODO 自动生成的方法存根
		this.noticeDao.updateNotice(notice);

	}

	
	@Override
	public void deleteNotice(long id) {
		// TODO 自动生成的方法存根

		this.noticeDao.deleteNotice(id);
	}

	
	@Override
	public List<Notice> listNotice() {
		// TODO 自动生成的方法存根
		return this.noticeDao.listNotice();
	}

	@Override
	public Notice findById(long id) {
		// TODO Auto-generated method stub
		return this.noticeDao.findById(id);
	}

}
