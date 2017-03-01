/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.AttachDownloadDao;
import com.bbsBlog.entity.AttachDownload;
import com.bbsBlog.service.AttachDownloadService;

/**
 * @author Robust
 *
 * @date 2014年9月20日
 *
 */
@Service("attachDownloadService")
public class AttachDownloadServiceImpl implements AttachDownloadService {

	@Resource
	private AttachDownloadDao attachDownloadDao;
	/* （非 Javadoc）
	 * @see com.bbsBlog.service.AttachDownloadService#saveAttachDownload(com.bbsBlog.entity.AttachDownload)
	 * @param attachDownload
	 *
	 * @author Robust
	 * @date 2014年9月20日
	 *
	 */
	@Override
	public void saveAttachDownload(AttachDownload attachDownload) {
		// TODO 自动生成的方法存根
		this.attachDownloadDao.saveAttachDownload(attachDownload);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.AttachDownloadService#updateAttachDownload(com.bbsBlog.entity.AttachDownload)
	 * @param attachDownload
	 *
	 * @author Robust
	 * @date 2014年9月20日
	 *
	 */
	@Override
	public void updateAttachDownload(AttachDownload attachDownload) {
		// TODO 自动生成的方法存根
		this.attachDownloadDao.updateAttachDownload(attachDownload);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.AttachDownloadService#deleteAttachDownload(long)
	 * @param id
	 *
	 * @author Robust
	 * @date 2014年9月20日
	 *
	 */
	@Override
	public void deleteAttachDownload(long id) {
		// TODO 自动生成的方法存根
		this.attachDownloadDao.deleteAttachDownload(id);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.AttachDownloadService#listAttachDownloadBySql(java.lang.String)
	 * @param sql
	 * @return
	 *
	 * @author Robust
	 * @date 2014年9月22日
	 *
	 */
	@Override
	public List<AttachDownload> listAttachDownloadBySql(String sql) {
		// TODO 自动生成的方法存根
		return this.attachDownloadDao.listAttachDownloadBy(sql);
	}

}
