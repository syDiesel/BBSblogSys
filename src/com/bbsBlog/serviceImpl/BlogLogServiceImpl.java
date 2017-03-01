/**
 * 
 */
package com.bbsBlog.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bbsBlog.dao.BlogLogDao;
import com.bbsBlog.entity.BlogLog;
import com.bbsBlog.service.BlogLogService;
import com.bbsBlog.util.PageModel;

/**
 * @author Robust
 *
 * @date 2014年7月30日
 *
 */
@Service("blogLogServiceImpl")
public class BlogLogServiceImpl implements BlogLogService {

	@Resource
	private BlogLogDao blogLogDao;

	/**
	 * @return blogLogDao
	 */
	public BlogLogDao getBlogLogDao() {
		return blogLogDao;
	}

	/**
	 * @param blogLogDao
	 *            要设置的 blogLogDao
	 */
	public void setBlogLogDao(BlogLogDao blogLogDao) {
		this.blogLogDao = blogLogDao;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.BlogLogService#saveBlogLog(com.bbsBlog.entity.BlogLog
	 * )
	 */
	@Override
	public void saveBlogLog(BlogLog blogLog) {
		// TODO 自动生成的方法存根
		this.blogLogDao.saveBlogLog(blogLog);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.service.BlogLogService#updateBlogLog(com.bbsBlog.entity.BlogLog
	 * )
	 */
	@Override
	public void updateBlogLog(BlogLog blogLog) {
		// TODO 自动生成的方法存根
		this.blogLogDao.updateBlogLog(blogLog);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.BlogLogService#deleteBlogLog(long)
	 */
	@Override
	public void deleteBlogLog(long id) {
		// TODO 自动生成的方法存根
		this.blogLogDao.deleteBlogLog(id);
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.service.BlogLogService#listBlogLog()
	 */
	@Override
	public List<BlogLog> listBlogLog() {
		// TODO 自动生成的方法存根
		return this.blogLogDao.listBlogLog();
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.BlogLogService#listBloglog(int, int)
	 * @param offset
	 * @param pageSize
	 * @return
	 *
	 * @author Robust
	 * @date 2014年8月14日
	 *
	 */
	@Override
	public PageModel listBloglog(int offset, int pageSize) {
		// TODO 自动生成的方法存根
		return this.blogLogDao.listBloglog(offset, pageSize);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.BlogLogService#listBlogLogById(long)
	 * @param id
	 * @return
	 *
	 * @author Robust
	 * @date 2014年8月14日
	 *
	 */
	@Override
	public BlogLog listBlogLogById(long id) {
		// TODO 自动生成的方法存根
		return this.blogLogDao.listBlogLogById(id);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.BlogLogService#listBloglogByBlog(int, int, long)
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
	public PageModel listBloglogByBlog(int offset, int pageSize, long BlogId) {
		// TODO 自动生成的方法存根
		return this.blogLogDao.listBloglogByBlog(offset, pageSize, BlogId);
	}

	@Override
	public List<BlogLog> listBlogLogByKey(String keyword, String lab, String sub, String con) {
		// TODO Auto-generated method stub
		return this.blogLogDao.listBlogLogByKey(keyword,lab,sub,con);
	}

	@Override
	public List<BlogLog> listBlogLogByTime(String keyword, String lab, String sub, String con) {
		// TODO Auto-generated method stub
		return this.blogLogDao.listBlogLogByTime(keyword,lab,sub,con);
	}

	/*@Override
	public List listAllByKey(String keyword) {
		// TODO Auto-generated method stub
		return this.blogLogDao.listAllByKey(keyword);
	}

	@Override
	public List listAllByTime(String keyword) {
		// TODO Auto-generated method stub
		return this.blogLogDao.listAllByTime(keyword);
	}
	*/
	
	
	@Override
	public List<BlogLog> listBlogByBoard(long board_id){
		// TODO Auto-generated method stub
		return this.blogLogDao.listBlogByBoard(board_id);
	}

	@Override
	public List<BlogLog> listBlogLogByBlogId(long id) {
		// TODO Auto-generated method stub
		return this.blogLogDao.listBlogLogByBlogId(id);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.BlogLogService#listBloglogBySQL(int, int, java.lang.String, java.lang.String)
	 * @param offset
	 * @param pageSize
	 * @param queryCountHql
	 * @param hql
	 * @return
	 *
	 * @author Robust
	 * @date 2014年9月30日
	 *
	 */
	@Override
	public PageModel listBloglogBySQL(int offset, int pageSize,
			String queryCountHql, String hql) {
		// TODO 自动生成的方法存根
		return this.blogLogDao.listBloglogBySQL(offset, pageSize, queryCountHql, hql);
	}

	/* （非 Javadoc）
	 * @see com.bbsBlog.service.BlogLogService#listCount(java.lang.String)
	 * @param queryCountHql
	 * @return
	 *
	 * @author Robust
	 * @date 2014年10月10日
	 *
	 */
	@Override
	public int listCount(String queryCountHql) {
		// TODO 自动生成的方法存根
		return this.blogLogDao.listCount(queryCountHql);
	}

	@Override
	public List<BlogLog> listBlogLogBySql(String sql) {
		// TODO Auto-generated method stub
		return this.blogLogDao.listBlogLogBySql(sql);
	}
	

}
