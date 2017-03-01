/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.PostStatusDao;
import com.bbsBlog.entity.PostStatus;
import com.bbsBlog.service.PostStatusService;

/**
 * @author Robust
 *
 * @date 2014年7月30日
 *
 */
@Service("postStatusService")
public class PostStatusServiceImpl implements PostStatusService {

	@Resource
	private PostStatusDao postStatusDao;

	/**
	 * @return postStatusDao
	 */
	public PostStatusDao getPostStatusDao() {
		return postStatusDao;
	}

	/**
	 * @param postStatusDao
	 *            要设置的 postStatusDao
	 */
	public void setPostStatusDao(PostStatusDao postStatusDao) {
		this.postStatusDao = postStatusDao;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.PostStatusService#savePostStatus(com.bbsBlog.entity
	 * .PostStatus)
	 */
	@Override
	public void savePostStatus(PostStatus postStatus) {
		// TODO 自动生成的方法存根

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.PostStatusService#updatePostStatus(com.bbsBlog.entity
	 * .PostStatus)
	 */
	@Override
	public void updatePostStatus(PostStatus postStatus) {
		// TODO 自动生成的方法存根

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.PostStatusService#deletePostStatus(long)
	 */
	@Override
	public void deletePostStatus(long id) {
		// TODO 自动生成的方法存根

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.PostStatusService#listPostStatus()
	 */
	@Override
	public List<PostStatus> listPostStatus() {
		// TODO 自动生成的方法存根
		return null;
	}
	
	@Override
	public PostStatus listPostStatusById(long status_id){
		return this.postStatusDao.listPostStatusById(status_id);
	}

}
