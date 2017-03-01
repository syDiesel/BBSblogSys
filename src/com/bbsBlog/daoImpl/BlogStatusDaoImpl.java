/**
 * 
 */
package com.bbsBlog.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bbsBlog.dao.BlogStatusDao;
import com.bbsBlog.entity.BlogStatus;

/**
 * @author Robust
 *
 * @date 2014年7月28日
 *
 */
@Repository("blogStatusDao")
public class BlogStatusDaoImpl implements BlogStatusDao {

	@Resource
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.dao.BlogStatusDao#saveBlogStatus(com.bbsBlog.entity.BlogStatus
	 * )
	 */
	@Override
	public void saveBlogStatus(BlogStatus blogStatus) {
		// TODO 自动生成的方法存根

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see
	 * com.bbsBlog.dao.BlogStatusDao#updateBlogStatus(com.bbsBlog.entity.BlogStatus
	 * )
	 */
	@Override
	public void updateBlogStatus(BlogStatus blogStatus) {
		// TODO 自动生成的方法存根

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.BlogStatusDao#deleteBlogStatus(long)
	 */
	@Override
	public void deleteBlogStatus(long id) {
		// TODO 自动生成的方法存根

	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see com.bbsBlog.dao.BlogStatusDao#listBlogStatus()
	 */
	@Override
	public List<BlogStatus> listBlogStatus() {
		// TODO 自动生成的方法存根
		return null;
	}

	
	public BlogStatus listBlogStatusById(long id){
		return this.hibernateTemplate.get(BlogStatus.class, id);
	}
}
