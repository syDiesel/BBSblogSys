/**
 * 
 */
package com.bbsBlog.dao;

import java.util.List;

import com.bbsBlog.entity.Attachment;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月26日
 *
 */
public interface AttachmentDao {

	public void saveAttachment(Attachment attachment);

	public void updateAttachment(Attachment attachment);

	public void deleteAttachment(long id);

	public List<Attachment> listAttachment();

	public PageModel listAttachment(int offset,int pageSize);
	
	public PageModel listAttachmentByBlogId(int offset,int pageSize,long BlogId);
	
	public Attachment listAttachmentById(long id);
	
	public List<Attachment> listAttachmentByKey(String keyword, String lab, String sub, String con);
	
	public List<Attachment> listAttachmentByTime(String keyword, String lab, String sub, String con);

    public List<Attachment> listAttachBySql(String sql);
}
