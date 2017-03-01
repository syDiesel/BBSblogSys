/**
 * 
 */
package com.bbsBlog.dao;

import java.util.List;

import com.bbsBlog.entity.AttachDownload;

/**
 * @author Robust
 *
 * @date 2014年9月18日
 *
 */
public interface AttachDownloadDao {
	public void saveAttachDownload(AttachDownload attachDownload);

	public void updateAttachDownload(AttachDownload attachDownload);

	public void deleteAttachDownload(long id);

	public List<AttachDownload> listAttachDownloadBy(String sql);
	
}
