/**
 * 
 */
package com.bbsBlog.service;

import java.util.List;

import com.bbsBlog.entity.Attachment;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月29日
 *
 */
public interface AttachmentService {

	public void saveAttachment(Attachment attachment);

	public void updateAttachment(Attachment attachment);

	public void deleteAttachment(long id);

	public List<Attachment> listAttachment();

	public PageModel listAttachment(int offset, int pageSize);

	public PageModel listAttachmentByBlogId(int offset, int pageSize,
			long BlogId);

	public Attachment listAttachment(long id);
	
	public List<Attachment> listAttachmentByKey(String keyword, String lab, String sub, String con);
	
	public List<Attachment> listAttachmentByTime(String keyword, String lab, String sub, String con);
	
	public List<Attachment> listAttachBySql(String sql);
}
