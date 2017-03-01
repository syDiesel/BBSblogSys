/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.AttachmentDao;
import com.bbsBlog.entity.Attachment;
import com.bbsBlog.service.AttachmentService;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月30日
 *
 */
@Service("attachmentService")
public class AttachmentServiceImpl implements AttachmentService {

	@Resource
	private AttachmentDao attachmentDao;

	/**
	 * @return attachmentDao
	 */
	public AttachmentDao getAttachmentDao() {
		return attachmentDao;
	}

	/**
	 * @param attachmentDao
	 *            要设置的 attachmentDao
	 */
	public void setAttachmentDao(AttachmentDao attachmentDao) {
		this.attachmentDao = attachmentDao;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.AttachmentService#saveAttachment(com.bbsBlog.entity
	 * .Attachment)
	 */
	@Override
	public void saveAttachment(Attachment attachment) {
		// TODO 自动生成的方法存根
		this.attachmentDao.saveAttachment(attachment);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.AttachmentService#updateAttachment(com.bbsBlog.entity
	 * .Attachment)
	 */
	@Override
	public void updateAttachment(Attachment attachment) {
		// TODO 自动生成的方法存根
		this.attachmentDao.updateAttachment(attachment);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.AttachmentService#deleteAttachment(long)
	 */
	@Override
	public void deleteAttachment(long id) {
		// TODO 自动生成的方法存根
		this.attachmentDao.deleteAttachment(id);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.AttachmentService#listAttachment()
	 */
	@Override
	public List<Attachment> listAttachment() {
		// TODO 自动生成的方法存根
		return this.attachmentDao.listAttachment();
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.AttachmentService#listAttachment(int, int)
	 * @param offset
	 * @param pageSize
	 * @return
	 *
	 * @author Robust
	 * @date 2014年8月31日
	 *
	 */
	@Override
	public PageModel listAttachment(int offset, int pageSize) {
		// TODO 自动生成的方法存根
		return this.attachmentDao.listAttachment(offset, pageSize);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.AttachmentService#listAttachment(long)
	 * @param id
	 * @return
	 *
	 * @author Robust
	 * @date 2014年9月3日
	 *
	 */
	@Override
	public Attachment listAttachment(long id) {
		// TODO 自动生成的方法存根
		return this.attachmentDao.listAttachmentById(id);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.AttachmentService#listAttachmentByBlogId(int, int, long)
	 * @param offset
	 * @param pageSize
	 * @param BlogId
	 * @return
	 *
	 * @author Robust
	 * @date 2014年9月16日
	 *
	 */
	@Override
	public PageModel listAttachmentByBlogId(int offset, int pageSize,
			long BlogId) {
		// TODO 自动生成的方法存根
		return this.attachmentDao.listAttachmentByBlogId(offset, pageSize, BlogId);
	}

	@Override
	public List<Attachment> listAttachmentByKey(String keyword, String lab, String sub, String con) {
		// TODO Auto-generated method stub
		return this.attachmentDao.listAttachmentByKey(keyword,lab,sub,con);
	}

	@Override
	public List<Attachment> listAttachmentByTime(String keyword, String lab, String sub, String con) {
		// TODO Auto-generated method stub
		return this.attachmentDao.listAttachmentByTime(keyword,lab,sub,con);
	}

	@Override
	public List<Attachment> listAttachBySql(String sql) {
		// TODO Auto-generated method stub
		return this.attachmentDao.listAttachBySql(sql);
	}
	
	

}
