/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.BlogDao;
import com.bbsBlog.entity.Blog;
import com.bbsBlog.entity.UserInfo;
import com.bbsBlog.service.BlogService;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月30日
 *
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService {

	@Resource
	private BlogDao blogDao;

	/**
	 * @return blogDao
	 */
	public BlogDao getBlogDao() {
		return blogDao;
	}

	/**
	 * @param blogDao
	 *            要设置的 blogDao
	 */
	public void setBlogDao(BlogDao blogDao) {
		this.blogDao = blogDao;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.BlogService#saveBlog(com.bbsBlog.entity.Blog)
	 */
	public void saveBlog(Blog blog) {
		// TODO 自动生成的方法存根
		this.blogDao.saveBlog(blog);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.BlogService#updateBlog(com.bbsBlog.entity.Blog)
	 */
	public void updateBlog(Blog blog) {
		// TODO 自动生成的方法存根
		this.blogDao.updateBlog(blog);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.BlogService#deleteBlog(long)
	 */
	public void deleteBlog(long id) {
		// TODO 自动生成的方法存根
		this.blogDao.deleteBlog(id);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.BlogService#listBlog()
	 */
	public List<Blog> listBlog() {
		// TODO 自动生成的方法存根
		return this.blogDao.listBlog();
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.BlogService#listBlog(int, int)
	 * @param offset
	 * @param pageSize
	 * @return
	 *
	 * @author Robust
	 * @date 2014年8月14日
	 *
	 */
	public PageModel listBlog(int offset, int pageSize) {
		// TODO 自动生成的方法存根
		return this.blogDao.listBlog(offset, pageSize);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.BlogService#listBlogBySql(java.lang.String)
	 * @param sql
	 * @return
	 *
	 * @author Robust
	 * @date 2014年8月14日
	 *
	 */
	public List<Blog> listBlogBySql(String sql) {
		// TODO 自动生成的方法存根
		return this.blogDao.listBlogBySql(sql);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.BlogService#listBlogById(long)
	 * @param id
	 * @return
	 *
	 * @author Robust
	 * @date 2014年9月16日
	 *
	 */
	@Override
	public Blog listBlogById(long id) {
		// TODO 自动生成的方法存根
		return this.blogDao.listBlogById(id);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.BlogService#listBlog(int, int, java.lang.String, java.lang.String)
	 * @param offset
	 * @param pageSize
	 * @param queryCountHql
	 * @param hql
	 * @return
	 *
	 * @author Robust
	 * @date 2014年10月5日
	 *
	 */
	@Override
	public PageModel listBlog(int offset, int pageSize, String queryCountHql,
			String hql) {
		// TODO 自动生成的方法存根
		return this.blogDao.listBlog(offset, pageSize, queryCountHql, hql);
	}

	@Override
	public List<Blog> findBlogByUserInfo(UserInfo userInfo) {
		// TODO Auto-generated method stub
		return this.blogDao.findBlogByUserInfo(userInfo);
	}

}
