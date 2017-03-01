/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import com.bbsBlog.dao.BlogHiDao;
import com.bbsBlog.entity.BlogHI;
import com.bbsBlog.entity.UserInfo;
import com.bbsBlog.service.BlogHiService;

/**
 * @author Robust
 *
 * @date 2014年9月17日
 *
 */
@Service("BlogHiService")
public class BlogHiServiceImpl implements BlogHiService {

	@Resource
	private BlogHiDao blogHiDao;

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.BlogHiService#saveBlogHi(com.bbsBlog.entity.BlogHI)
	 * 
	 * @param blogHi
	 * 
	 * @author Robust
	 * 
	 * @date 2014年9月17日
	 */
	@Override
	public void saveBlogHi(BlogHI blogHi) {
		// TODO 自动生成的方法存根
		this.blogHiDao.saveBlogHi(blogHi);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.BlogHiService#deleteBlogHi(long)
	 * 
	 * @param id
	 * 
	 * @author Robust
	 * 
	 * @date 2014年9月17日
	 */
	@Override
	public void deleteBlogHi(long id) {
		// TODO 自动生成的方法存根
		this.blogHiDao.deleteBlogHi(id);

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.BlogHiService#updateBlogHi(com.bbsBlog.entity.BlogHI)
	 * 
	 * @param blogHi
	 * 
	 * @author Robust
	 * 
	 * @date 2014年9月17日
	 */
	@Override
	public void updateBlogHi(BlogHI blogHi) {
		// TODO 自动生成的方法存根
		this.blogHiDao.updateBlogHi(blogHi);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.BlogHiService#listBlogHiByUserAndBlog(long, long)
	 * @param userInfoId
	 * @param blogId
	 * @return
	 *
	 * @author Robust
	 * @date 2014年9月17日
	 *
	 */
	@Override
	public List<BlogHI> listBlogHiByUserAndBlog(long userInfoId, long blogId,String time) {
		// TODO 自动生成的方法存根
		return this.blogHiDao.listBlogHiByUserAndBlog(userInfoId, blogId,time);
	}

	@Override
	public UserInfo listUserByBlogLog(long id) {
		// TODO Auto-generated method stub
		return this.blogHiDao.listUserByBlogLog(id);
	}

	public int listCount(String queryCountHql) {
		// TODO 自动生成的方法存根

		return this.blogHiDao.listCount(queryCountHql);
	}
	
}
