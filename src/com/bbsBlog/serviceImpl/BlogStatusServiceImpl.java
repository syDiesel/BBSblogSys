/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.BlogStatusDao;
import com.bbsBlog.entity.BlogStatus;
import com.bbsBlog.service.BlogStatusService;

/**
 * @author Robust
 *
 * @date 2014年7月30日
 *
 */
@Service("blogStatusService")
public class BlogStatusServiceImpl implements BlogStatusService {

	@Resource
	private BlogStatusDao blogStatusDao;

	/**
	 * @return blogStatusDao
	 */
	public BlogStatusDao getBlogStatusDao() {
		return blogStatusDao;
	}

	/**
	 * @param blogStatusDao
	 *            要设置的 blogStatusDao
	 */
	public void setBlogStatusDao(BlogStatusDao blogStatusDao) {
		this.blogStatusDao = blogStatusDao;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.BlogStatusService#saveBlogStatus(com.bbsBlog.entity
	 * .BlogStatus)
	 */
	@Override
	public void saveBlogStatus(BlogStatus blogStatus) {
		// TODO 自动生成的方法存根

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.BlogStatusService#updateBlogStatus(com.bbsBlog.entity
	 * .BlogStatus)
	 */
	@Override
	public void updateBlogStatus(BlogStatus blogStatus) {
		// TODO 自动生成的方法存根

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.BlogStatusService#deleteBlogStatus(long)
	 */
	@Override
	public void deleteBlogStatus(long id) {
		// TODO 自动生成的方法存根

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.BlogStatusService#listBlogStatus()
	 */
	@Override
	public List<BlogStatus> listBlogStatus() {
		// TODO 自动生成的方法存根
		return null;
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.BlogStatusService#listBlogStatusById(long)
	 * @param id
	 * @return
	 *
	 * @author Robust
	 * @date 2014年11月22日
	 *
	 */
	@Override
	public BlogStatus listBlogStatusById(long id) {
		// TODO 自动生成的方法存根
		return this.blogStatusDao.listBlogStatusById(id);
	}

}
