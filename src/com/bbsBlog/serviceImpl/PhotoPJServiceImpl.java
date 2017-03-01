/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.PhotoPJDao;
import com.bbsBlog.entity.PhotoPJ;
import com.bbsBlog.service.PhotoPJService;

/**
 * @author Robust
 *
 * @date 2014年10月25日
 *
 */
@Service("photoPJService")
public class PhotoPJServiceImpl implements PhotoPJService {

	@Resource
	private PhotoPJDao photoPJdao;
	/* （非 Javadoc）
	 * @see com.bbsBlog.service.PhotoPJService#savePhotoPj(com.bbsBlog.entity.PhotoPJ)
	 * @param photoPj
	 *
	 * @author Robust
	 * @date 2014年10月25日
	 *
	 */
	@Override
	public void savePhotoPj(PhotoPJ photoPj) {
		
		this.photoPJdao.savePhotoPj(photoPj);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.PhotoPJService#findPhotoPjByUserAndPhoto(long, long)
	 * @param userId
	 * @param photoId
	 *
	 * @author Robust
	 * @date 2014年10月25日
	 *
	 */
	@Override
	public List<PhotoPJ> findPhotoPjByUserAndPhoto(long userId, long photoId) {
		
		return this.photoPJdao.findPhotoPjByUserAndPhoto(userId, photoId);
	}

}
